package ua.dev.webnauts.githublab.network

object HttpRoutes {

    //https://opentdb.com/api_config.php
    const val BASE_URL_STAJ = "https://opentdb.com"

    val BASE_URL = BASE_URL_STAJ // sharedPreference?.getString(BASE_URL_SERVER, BASE_URL_TEST) ?: BASE_URL_STAJ
    //Trivia
    val TRIVIA = "$BASE_URL/api.php"
}