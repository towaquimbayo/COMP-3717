package com.bcit.myminiapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bcit.myminiapp.data.Deal

@Composable
fun Home(dealState: DealsState, favouriteList: MutableList<Deal>, changeColor: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .background(Color(0xFF2B2B2B))
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 10.dp)) {
            items(dealState.deals.value.size) {
                DealsCard(dealState.deals.value[dealState.deals.value.size - 1 - it], favouriteList, changeColor)
            }
        }
    }
}