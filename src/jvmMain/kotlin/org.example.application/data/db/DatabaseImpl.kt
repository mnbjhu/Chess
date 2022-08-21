package org.example.application.data.db

import api.RedisGraph
import org.example.application.util.Config
import org.example.application.util.config

class DatabaseImpl: Database {
    override fun getInstance() = databaseInstance
    companion object {
        @JvmStatic
        val databaseInstance by lazy {
            RedisGraph(
                name = "ChessServerGraph",
                host = config[Config.server_host],
                port = config[Config.server_port],
                password = config[Config.server_pass],
            )
        }
    }
}