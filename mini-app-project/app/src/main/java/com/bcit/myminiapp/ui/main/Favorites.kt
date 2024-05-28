package com.bcit.myminiapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.myminiapp.data.Deal

@Composable
fun Favorites(
    favouriteList: MutableList<Deal>,
    clearFavouriteList: () -> Unit,
    changeColor: (Long) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF2B2B2B))
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (favouriteList.isEmpty()) {
            Text(
                "You have no game deals saved :(",
                Modifier.padding(vertical = 10.dp),
                Color.White,
                20.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily.Monospace,
            )
        } else {
            Button(
                onClick = {
                    clearFavouriteList()
                    changeColor(0xFF000000)
                },
                shape = RectangleShape,
                modifier = Modifier.padding(vertical = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6466C9),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Clear All",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily.Monospace
                )
            }
            LazyColumn(modifier = Modifier.padding(bottom = 10.dp)) {
                items(favouriteList.size) {
                    DealsCard(favouriteList[favouriteList.size - 1 - it])
                }
            }
        }
    }
}