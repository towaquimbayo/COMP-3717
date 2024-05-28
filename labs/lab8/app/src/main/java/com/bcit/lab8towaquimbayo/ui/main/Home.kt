package com.bcit.lab8towaquimbayo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController, onColorItemClick: (Long) -> Unit) {
    val list = listOf(
        0xFFF44336,
        0xFFE91E63,
        0xFF9C27B0,
        0xFF3F51B5,
        0xFF2196F3,
        0xFF009688,
        0xFF4CAF50,
        0xFFFFEB3B
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        content = {
            items(list.size) {
                ColorItem(list[it], navController, onColorItemClick)
            }
        })
}

@Composable
fun ColorItem(color: Long, navController: NavController, onColorItemClick: (Long) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .background(Color(color))
            .height(100.dp)
            .clickable { onColorItemClick(color) }
    ) {
        IconButton(onClick = { navController.navigate("${Screen.INFO.route}/${color}") }) {
            Icon(Icons.Outlined.Info, contentDescription = null)
        }
    }
}