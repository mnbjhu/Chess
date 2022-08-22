package org.example.application.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.addIndexPage(){
    routing {
        get("/app/login") {
            call.respondHtml(HttpStatusCode.OK, HTML::index)
        }
        get("/app/register") {
            call.respondHtml(HttpStatusCode.OK, HTML::index)
        }
        authenticate("auth-session"){
            get("/app/{...}") {
                call.respondHtml(HttpStatusCode.OK, HTML::index)
            }
        }
        static("/static") {
            resources()
        }
    }
}
fun HTML.index() {
    head {
        title("Chess!")
    }
    body {
        div { id = "root" }
        script(src = "/static/Chess.js") {}
    }
}