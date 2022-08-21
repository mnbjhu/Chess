package org.example.application.data.repo

import functions.math.Id
import io.ktor.util.*
import models.LoginDetails
import models.User
import org.example.application.data.db.Database
import org.example.application.data.db.DatabaseImpl
import org.example.application.data.db.schema.UserNode
import org.example.application.data.db.schema.UserSession
import org.example.application.domain.exceptions.user.UserException
import org.example.application.domain.repos.UserRepo
import org.mindrot.jbcrypt.BCrypt
import paths.minus
import kotlin.random.Random

class UserRepoImpl(database: Database = DatabaseImpl()): UserRepo {
    private val graph = database.getInstance()
    private fun UserNode.hasDetails(details: LoginDetails) = (username eq details.username) and (passwordHash eq hash(details.password))
    override fun createUser(loginDetails: LoginDetails): Long{
        val usernameAvailable = graph.query {
            val user = match(UserNode())
            where((user.username eq loginDetails.username))
            result(user.username)
        }.isEmpty()
        return if(usernameAvailable){
            graph.create(UserNode::class){
                username[loginDetails.username]
                passwordHash[hash(loginDetails.password)]
            }
            graph.query {
                val user = match(UserNode())
                where((user.username eq loginDetails.username))
                result(Id(user))
            }.first()
        } else throw UserException.UsernameIsTakenException
    }
    override fun validateLoginDetails(details: LoginDetails): Long {
        val (userId, passwordHash) = graph.query {
            val user = match(UserNode())
            where(user.username eq details.username)
            val id = Id(user)
            result(id, user.passwordHash){
                id() to user.passwordHash()
            }
        }.firstOrNull() ?: throw UserException.InvalidLoginDetailsException
        if(!BCrypt.checkpw(details.password, passwordHash)) throw UserException.InvalidLoginDetailsException
        return userId
    }
    override fun validateUserSession(userId: Long, sessionKey: String) =
        graph.query {
            val (user, session) = match(UserNode() - { authorizedBy } - UserSession() ).nodes()
            where((Id(user) eq userId) and (session.key eq sessionKey))
            result(Id(user))
        }.isNotEmpty()

    override fun createUserSession(userId: Long): String {
        val sessionKey = Random.nextBytes(128)
            .joinToString { it.toInt().toChar().toString() }
        graph.create(UserSession::class){
            key[sessionKey]
            id[userId]
        }
        val userExists = graph.query {
            val (user, session) = match(UserNode(), UserSession())
            where((Id(user) eq userId) and (session.id eq userId) )
            create(user - { authorizedBy } - session)
            result(user.username)
        }.isNotEmpty()
        return if(userExists) sessionKey
        else {
            graph.query {
                val session = match(UserSession())
                where(session.id eq userId)
                delete(session)
            }
            throw UserException.InvalidLoginDetailsException
        }
    }

    override fun deleteUserSession(userId: Long) {
        val userDoesNotExist = graph.query {
            val (user, session) = match(UserNode() - { authorizedBy } - UserSession()).nodes()
            where(Id(user) eq userId)
            result(session.key)
        }.isEmpty()
        if (userDoesNotExist) throw UserException.UserIdNotFoundException(userId)
        graph.query {
            val session = match(UserSession())
            where(session.id eq userId)
            delete(session)
        }
    }

    override fun getUserId(username: String) = graph.query {
        val user = match(UserNode())
        where(user.username eq username)
        result(Id(user))
    }.firstOrNull() ?: throw UserException.UsernameNotFoundException(username)

    companion object{
        @JvmStatic
        private fun hash(password: String) = BCrypt.hashpw(password, BCrypt.gensalt())
    }
}