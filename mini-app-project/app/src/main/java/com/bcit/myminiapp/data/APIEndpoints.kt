package com.bcit.myminiapp.data

enum class APIEndpoints(val url: String) {
    BASE_URL("https://www.cheapshark.com/api/1.0"),
    DEALS("${BASE_URL.url}/deals"),
    GAMES("${BASE_URL.url}/games"),
}