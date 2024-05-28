package com.bcit.lab8towaquimbayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bcit.lab8towaquimbayo.ui.main.MainContent

/**
 * Towa Quimbayo
 * A01086002, Set U
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent() }
    }
}