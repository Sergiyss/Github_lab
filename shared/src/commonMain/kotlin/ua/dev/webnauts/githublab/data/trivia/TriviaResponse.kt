package ua.dev.webnauts.githublab.data.trivia


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TriviaResponse(
    @SerialName("response_code")
    val responseCode: Int = 0,
    @SerialName("results")
    val results: List<Result> = listOf()
)