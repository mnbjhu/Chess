package api

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlin.js.json

class Client {
    companion object{
        val instance by lazy {
            HttpClient(Js){
                install(ContentNegotiation){
                    json()
                }
            }
        }
    }
}