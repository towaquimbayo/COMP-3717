package com.bcit.lab9towaquimbayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.bcit.lab9towaquimbayo.ui.main.MainContent
import com.bcit.lab9towaquimbayo.ui.main.UserState

/**
 * Towa Quimbayo
 * Set U, A01086002
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userRepository = (application as MyApp).userRepository
        setContent {
            val userState = remember {
                UserState(userRepository)
            }
            MainContent(userState)
        }
    }
}