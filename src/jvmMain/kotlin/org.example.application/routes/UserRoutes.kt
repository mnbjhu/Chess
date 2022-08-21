package org.example.application.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import models.LoginDetails
import org.example.application.Session
import org.example.application.data.repo.UserRepoImpl
import org.example.application.domain.exceptions.user.UserException
import org.example.application.domain.repos.UserRepo

fun Application.addUserRoutes(repo: UserRepo = UserRepoImpl()){
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
            try {
                val userId = repo.validateLoginDetails(userDetails)
                val session = repo.createUserSession(userId)
                call.sessions.set(Session(userId, session))
                call.respondRedirect("/")
            } catch (e: UserException){ call.respondText(e.message, status = e.statusCode) }
        }
    }
}