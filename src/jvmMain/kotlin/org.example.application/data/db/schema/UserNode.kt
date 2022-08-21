package org.example.application.data.db.schema

import api.RedisNode
import api.RedisRelation

class UserNode: RedisNode("User") {
    val username = string("username")
    val passwordHash = string("password")
    val authorizedBy = relates(Authorized::class)
}
class Authorized: RedisRelation<UserNode, UserSession>("AUTHORIZED_BY")