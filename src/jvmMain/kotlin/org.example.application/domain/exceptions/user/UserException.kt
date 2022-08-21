package org.example.application.domain.exceptions.user

import io.ktor.http.*

sealed class UserException(
    override val message: String?,
    val statusCode: HttpStatusCode,
    ): Exception(){
    class UserIdNotFoundException(id: Long):UserException("User id not found: $id", HttpStatusCode.NotFound)
    class UsernameIsTakenException: UserException("Username is already taken", HttpStatusCode.BadRequest)
    class InvalidLoginDetailsException: UserException("Username or password is incorrect", HttpStatusCode.Unauthorized)
}
