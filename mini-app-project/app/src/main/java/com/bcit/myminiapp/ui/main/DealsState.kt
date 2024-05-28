package com.bcit.myminiapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.bcit.myminiapp.data.Deal
import com.bcit.myminiapp.data.DealRepository

class DealsState(private val dealRepository: DealRepository) {
    val deals: MutableState<List<Deal>> = mutableStateOf(emptyList())
    suspend fun getDeals() {
        deals.value = dealRepository.getDeals().deals
    }
}