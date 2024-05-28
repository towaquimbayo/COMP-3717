package com.bcit.myminiapp

import android.app.Application
import com.bcit.myminiapp.data.DealRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {
    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }

    val dealRepository = lazy { DealRepository(client) }
}