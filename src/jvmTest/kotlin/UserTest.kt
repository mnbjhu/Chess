import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.*
import models.LoginDetails

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UserTest {
    @Test
    fun testRoot() = testApplication {
        val client2: HttpClient = createClient {
            install(ContentNegotiation){
                json()
            }
        }
        val signUpResponse = client2.post("/api/register"){
            setBody(LoginDetails("TestUser", "Password123"))
        }
        assertEquals(HttpStatusCode.OK, signUpResponse.status)
        val loginResponse = client2.post("/api/login"){
            setBody(LoginDetails("TestUser", "Password123"))
        }
        assertEquals(HttpStatusCode.OK, loginResponse.status)
        val private = client2.post("/api/auth")
        assertEquals(HttpStatusCode.OK, private.status)
        assertEquals("Hello, World!", private.bodyAsText())
    }
}