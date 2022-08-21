package api

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Client {
    companion object{
        fun getInstance() = instance
        val instance = HttpClient(Js){
                install(ContentNegotiation){
                    json(
                        Json {
                            prettyPrint = true
                        }
                    )
                }
            }
    }
}