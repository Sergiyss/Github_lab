package ua.dev.webnauts.githublab

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform