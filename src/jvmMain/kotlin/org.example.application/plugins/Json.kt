package org.example.application.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.installJson() {
    install(ContentNegotiation){
        json()
    }
}