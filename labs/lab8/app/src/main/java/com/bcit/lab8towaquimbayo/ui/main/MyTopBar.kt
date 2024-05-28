package com.bcit.lab8towaquimbayo.ui.main

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController, color: Long) {
    CenterAlignedTopAppBar(title = { Text("Colors", fontSize = 24.sp) }, navigationIcon = {
        IconButton(onClick = { navController.navigate(Screen.HOME.route) }) {
            Icon(Icons.Rounded.Home, contentDescription = null)
        }
    }, actions = {
        Icon(
            Icons.Default.Star,
            contentDescription = null,
            tint = Color(color),
            modifier = Modifier.size(40.dp)
        )
    }, scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}