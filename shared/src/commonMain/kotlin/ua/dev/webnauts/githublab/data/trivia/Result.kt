package ua.dev.webnauts.githublab.data.trivia


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("category")
    val category: String = "",
    @SerialName("correct_answer")
    val correctAnswer: String = "",
    @SerialName("difficulty")
    val difficulty: String = "",
    @SerialName("incorrect_answers")
    val incorrectAnswers: List<String> = listOf(),
    @SerialName("question")
    val question: String = "",
    @SerialName("type")
    val type: String = ""
)