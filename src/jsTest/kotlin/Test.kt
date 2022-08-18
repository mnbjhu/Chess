import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.js.json
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun basicTest(){
        val client = HttpClient(Js){
            install(ContentNegotiation){
                json()
            }
        }
        GlobalScope.launch {
            val response = client.get("http://localhost:8080/")
            assertEquals(HttpStatusCode.OK, response.status)
        }
    }
}