package ua.dev.webnauts.githublab.network


import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import ua.dev.webnauts.githublab.data.trivia.TriviaResponse


@OptIn(ExperimentalSerializationApi::class)
val format = Json { explicitNulls = false }


class ServiceApiImpl constructor(
    private val client: HttpClient,
) : ServiceApi, SafeApiCall() {

    override suspend fun getTrivia(amount : Int): NetworkResponse<TriviaResponse> {
        return safeCall() {
            client.get(HttpRoutes.TRIVIA) {
                contentType(ContentType.Application.Json)
                parameter("amount", amount)
            }
        }
    }
}
