package org.example.application.data.db.schema

import api.RedisNode

class UserSession: RedisNode("Session") {
    val id = long("user_id")
    val key = string("key")
}