package ua.dev.webnauts.githublab.network

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*

abstract class SafeApiCall {

    suspend inline fun <reified T : Any> safeCall(
        request: () -> HttpResponse,
    ): NetworkResponse<T> {
        return try {
            request().let { response ->
                if (response.status.isSuccess()) {

                    NetworkResponse.Success(response.body())
                } else {

                    NetworkResponse.Error(
                        response.body(),
                        message = response.status.description,
                        code = response.status.value
                    )
                }
            }

        }catch (e: Exception) {
            NetworkResponse.Error(
                message = e.message ?: e.stackTraceToString(),
                code = -2
            )
        }

    }
}
