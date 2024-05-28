package com.bcit.lab8towaquimbayo.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class Screen(val route: String) {
    HOME("home"),
    INFO("info"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()
    var mainColor by remember { mutableLongStateOf(0xFFFFFFFF) }
    Scaffold(topBar = { MyTopBar(navController, mainColor) }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.HOME.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.HOME.route) {
                Home(navController) { mainColor = it }
            }
            composable(
                "${Screen.INFO.route}/{color}",
                arguments = listOf(navArgument("color") {
                    type = NavType.LongType
                })
            ) {
                Info(it.arguments?.getLong("color"))
            }
        }
    }
}