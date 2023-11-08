package ua.dev.webnauts.githublab

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn
import ua.dev.webnauts.githublab.data.trivia.TriviaResponse
import ua.dev.webnauts.githublab.network.NetworkResponse
import ua.dev.webnauts.githublab.network.ServiceApiImpl
import ua.dev.webnauts.githublab.network.httpClient
import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    private val serviceApiImpl = ServiceApiImpl(
        client = httpClient
    )

    fun greet(): String {
        return "Hello! ${platform.name}"
    }

    fun daysUntilNewYear(): Int {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val closestNewYear = LocalDate(today.year + 1, 1, 1)
        return today.daysUntil(closestNewYear)
    }

    fun getLaunches(): Flow<NetworkResponse<TriviaResponse>> = flow {
        serviceApiImpl.getTrivia().also { response->
            emit(response)
        }
    }
}