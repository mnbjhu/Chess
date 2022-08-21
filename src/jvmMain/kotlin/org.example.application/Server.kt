package org.example.application

import io.ktor.server.auth.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.example.application.plugins.installPlugins
import org.example.application.routes.addRoutes

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        installPlugins()
        addRoutes()
    }.start(wait = true)
}




data class Session(val userId: Long, val sessionKey: String): Principal