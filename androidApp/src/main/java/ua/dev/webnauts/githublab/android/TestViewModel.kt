package ua.dev.webnauts.githublab.android

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ua.dev.webnauts.githublab.data.trivia.TriviaResponse
import ua.dev.webnauts.githublab.network.NetworkResponse

class TestViewModel : ViewModel() {
    val greeting = ua.dev.webnauts.githublab.Greeting()

    private val _launches = mutableStateOf<TriviaResponse?>(null)
    val launches: State<TriviaResponse?> get() = _launches

    init {
        getLaunches()
    }


    fun getLaunches() {
        viewModelScope.launch {
            greeting.getLaunches().collect  {response->
                if(response is NetworkResponse.Success){
                    _launches.value = response.data
                }
                if(response is NetworkResponse.Error){
                    println("Error: ${response.message}")
                }
            }
        }
    }
}