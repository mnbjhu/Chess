package org.example.application.data

import api.RedisGraph

interface Database {
    val instance: RedisGraph
}
class DatabaseImpl : Database{
    override val instance: RedisGraph = RedisGraph("ChessGraph","localhost")
}