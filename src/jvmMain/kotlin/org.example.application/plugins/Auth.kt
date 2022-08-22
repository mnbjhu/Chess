package org.example.application.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*
import org.example.application.Session
import org.example.application.domain.repos.UserRepo

fun Application.installAuth(repo: UserRepo) {
    install(Authentication) {
        session<Session>("auth-session") {
            validate { session ->
                if (repo.validateUserSession(session.userId, session.sessionKey)) session
                else null
            }
            challenge {
                call.respondRedirect("/app/login")
            }
        }
    }
    install(Sessions) {
        cookie<Session>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60
            cookie.extensions["SameSite"] = "lax"
        }
    }
}