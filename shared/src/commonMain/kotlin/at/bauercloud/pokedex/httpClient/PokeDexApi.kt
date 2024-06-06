package at.bauercloud.pokedex.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class PokeDexApi {
    private val apiClient: HttpClient = HttpClient {
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, request ->
                val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
                val exceptionResponse = clientException.response

                when (exceptionResponse.status) {
                    HttpStatusCode.Unauthorized -> {
                        throw Exception(exceptionResponse.bodyAsText())
                    }
                    else -> println("Error: $exceptionResponse")
                }

                println("Do something with the error, set some values to handle it, ${exception.stackTraceToString()}")
            }
        }
    }


    internal fun getApiClient(): HttpClient {
        return apiClient
    }

}