package org.example.application.domain.repos

import models.User
import org.example.application.domain.exceptions.user.UserException

interface UserRepo {
    @Throws(UserException.UsernameIsTakenException::class)
    fun createUser(loginDetails: User.LoginDetails): Long // <- User Id
    fun validateUserSession(userId: Long, sessionKey: String): Boolean
    @Throws(UserException.InvalidLoginDetailsException::class)
    fun createUserSession(userId: Long): String
    @Throws(UserException.UserIdNotFoundException::class)
    fun deleteUserSession(userId: Long)
    fun validateLoginDetails(details: User.LoginDetails): Boolean
}