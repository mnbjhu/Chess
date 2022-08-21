package org.example.application.util

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File

object Config {
    private val config = ConfigurationProperties.fromResource("local.properties")
    val server_port = Key("server.port", intType)
    val server_host = Key("server.host", stringType)
    val server_pass = Key("server.pass", stringType)
}
val config = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromFile(File("/etc/chess_server.properties")) overriding
        ConfigurationProperties.fromResource("local.properties")