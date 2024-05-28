package com.bcit.myminiapp.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DealRepository(private val client: HttpClient) {
    suspend fun getDeals(): DealsList {
        val response = client.get(APIEndpoints.DEALS.url)
        val jsonArray = response.body<JsonArray>()
        Log.d("DealRepository", jsonArray.toString())
        return deserializeJson(jsonArray)
    }

    private fun deserializeJson(jsonArray: JsonArray): DealsList {
        return DealsList(
            deals = Gson().fromJson(
                jsonArray,
                object : TypeToken<List<Deal>>() {}.type
            )
        )
    }
}