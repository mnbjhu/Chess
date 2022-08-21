package org.example.application.data.db

import api.RedisGraph

interface Database {
    fun getInstance(): RedisGraph
}