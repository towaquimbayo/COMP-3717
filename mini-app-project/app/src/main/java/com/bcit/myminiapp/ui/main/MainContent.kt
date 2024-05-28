package com.bcit.myminiapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bcit.myminiapp.data.Deal

enum class Screen(val route: String) {
    HOME("home"),
    FAVOURITE("favorite"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(dealState: DealsState) {
    val navController = rememberNavController()
    val favouriteList = remember { mutableListOf<Deal>() }
    var mainColor by remember { mutableLongStateOf(0xFF000000) }
    Scaffold(topBar = { CustomTopBar(navController, mainColor) }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.HOME.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.HOME.route) {
                Home(dealState, favouriteList) { mainColor = it }
            }
            composable(Screen.FAVOURITE.route) {
                Favorites(favouriteList, { favouriteList.clear() }) { mainColor = it }
            }
        }
    }
}