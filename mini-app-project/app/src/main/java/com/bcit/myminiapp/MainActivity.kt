package com.bcit.myminiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.bcit.myminiapp.ui.main.DealsState
import com.bcit.myminiapp.ui.main.MainContent

/**
 * Towa Quimbayo
 * A01086002, Set U
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dealRepository = (application as MyApp).dealRepository
        setContent {
            val dealState = DealsState(dealRepository.value)
            LaunchedEffect(dealState) {
                dealState.getDeals()
            }
            MainContent(dealState)
        }
    }
}