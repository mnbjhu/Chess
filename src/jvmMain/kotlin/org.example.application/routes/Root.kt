package org.example.application.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.addRoutes(){
    addIndexPage()
    addUserRoutes()
}
