package models

import kotlinx.serialization.Serializable

@Serializable
class User(
    val loginDetails: LoginDetails,
    val sessionKey: String,
)
@Serializable
class LoginDetails(
    val username: String,
    val password: String,
)