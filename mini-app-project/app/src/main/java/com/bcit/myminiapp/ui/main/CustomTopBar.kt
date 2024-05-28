package com.bcit.myminiapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController, color: Long) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Best Game Deals", modifier = Modifier.padding(20.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF000000)
            )
        }, navigationIcon = {
            IconButton(onClick = { navController.navigate(Screen.HOME.route) }) {
                Icon(Icons.Rounded.Home, contentDescription = null)
            }
        }, actions = {
            IconButton(onClick = { navController.navigate(Screen.FAVOURITE.route) }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color(color),
                    modifier = Modifier.size(36.dp)
                )
            }
        }, scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}