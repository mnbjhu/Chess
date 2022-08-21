package org.example.application.domain.exceptions.user

import io.ktor.http.*

sealed class UserException(
    override val message: String,
    val statusCode: HttpStatusCode,
    ): Exception(){
    class UsernameNotFoundException(username: String): UserException("Username not found: $username", HttpStatusCode.NotFound)
    class UserIdNotFoundException(id: Long):UserException("User id not found: $id", HttpStatusCode.NotFound)
    object UsernameIsTakenException: UserException("Username is already taken", HttpStatusCode.BadRequest)
    object InvalidLoginDetailsException: UserException("Username or password is incorrect", HttpStatusCode.Unauthorized)
}
