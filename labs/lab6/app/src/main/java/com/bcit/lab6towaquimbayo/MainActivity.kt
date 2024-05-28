package com.bcit.lab6towaquimbayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Towa Quimbayo, A01086002
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(110, 132, 155, 255)),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                FirstRow()
                SecondRow()
                ThirdRow()
            }
        }
    }
}

@Composable
fun FirstRow() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color(22, 48, 195, 255)),
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(178, 6, 6, 255))
        )
    }
}

@Composable
fun SecondRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(128, 83, 210, 255))
            .padding(10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(223, 134, 134, 255)),
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(76, 174, 80, 255)),
        )
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(237, 191, 55, 255)),
        )
    }
}

@Composable
fun ThirdRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .background(Color(127, 85, 22, 255)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Lab 6",
                color = Color.White,
                fontSize = 42.sp,
            )
        }
    }
}