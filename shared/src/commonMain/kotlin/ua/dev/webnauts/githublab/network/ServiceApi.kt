package ua.dev.webnauts.githublab.network

import ua.dev.webnauts.githublab.data.trivia.TriviaResponse


interface ServiceApi {

    suspend fun getTrivia(amount : Int = 10): NetworkResponse<TriviaResponse>

}