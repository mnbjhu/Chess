package org.example.application.plugins

import io.ktor.server.application.*
import io.ktor.server.websocket.*
import java.time.Duration


fun Application.installWebSockets(){
    install(WebSockets){
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
}