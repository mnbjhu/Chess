package org.example.application.data.web_sockets

import io.ktor.network.sockets.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import org.example.application.Session
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.LinkedHashSet

fun Application.addNotificationWebsocket(){
    routing {
        webSocket("/api/notifications") {
            val thisConnection = Connection(this)
            val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())
            val sessionKey = call.sessions.get("user_session") as Session
            connections += thisConnection
            send("You've logged in as [UserId: ${sessionKey.userId}]")
            for (frame in incoming) {
                frame as? Frame.Text ?: continue
                val receivedText = frame.readText()
                val textWithUsername = "[${thisConnection.name}]: $receivedText"
                connections.forEach {
                    it.session.send(textWithUsername)
                }
            }
        }
    }
}
class Connection(val session: DefaultWebSocketSession) {
    companion object {
        val lastId = AtomicInteger(0)
    }
    val name = "user${lastId.getAndIncrement()}"
}