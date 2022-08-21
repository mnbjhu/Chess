package org.example.application.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import models.LoginDetails
import org.example.application.Session
import org.example.application.data.repo.UserRepoImpl
import org.example.application.domain.repos.UserRepo

fun Application.addUserRoutes(repo: UserRepo = UserRepoImpl()){
    installAuth(repo)
    routing {
        get("/test") {
            this
        }
    }
/*
    routing {
        authenticate("auth-session") {
            get("/api/auth"){
                call.respondText("Hello, World!")
            }
        }
        post("/api/register") {
            val userDetails: LoginDetails = call.receive()
            repo.createUser(userDetails)
            call.respond(HttpStatusCode.OK)
        }
        post("/api/login") {

            val userDetails: LoginDetails = call.receive()
            val userId = repo.validateLoginDetails(userDetails)
            val session = repo.createUserSession(userId)
            call.sessions.set(Session(userId, session))
            call.respondRedirect("/")
        }
    }*/
}

private fun Application.installAuth(repo: UserRepo) {
    install(Authentication) {
        session<Session>("auth-session") {
            validate { session ->
                if (repo.validateUserSession(session.userId, session.sessionKey)) {
                    session
                } else {
                    null
                }
            }
            challenge {
                call.respondRedirect("/login")
            }
        }
    }
    install(Sessions) {
        cookie<Session>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60
        }
    }
}