package com.bcit.lab7towaquimbayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Towa Quimbayo
 * A01086002, Set U
 */
data class Starwars(val name: String, val imageId: Int)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val starWarsNames = stringArrayResource(R.array.starwarsNames)
            val starWarsList = listOf(
                Starwars(starWarsNames[0], R.drawable.ahsoka),
                Starwars(starWarsNames[1], R.drawable.bb8),
                Starwars(starWarsNames[2], R.drawable.c3po),
                Starwars(starWarsNames[3], R.drawable.chewbacca),
                Starwars(starWarsNames[4], R.drawable.grogu),
                Starwars(starWarsNames[5], R.drawable.jabba),
                Starwars(starWarsNames[6], R.drawable.kilo),
                Starwars(starWarsNames[7], R.drawable.trooper),
                Starwars(starWarsNames[8], R.drawable.yoda),
            )
            MainContent(starWarsList)
        }
    }
}

@Composable
fun MainContent(starWarsList: List<Starwars>) {
    var shuffledList by remember { mutableStateOf(starWarsList) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        LazyColumn(modifier = Modifier.align(Alignment.TopCenter)) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        shape = RectangleShape,
                        onClick = { shuffledList = starWarsList.shuffled() }) {
                        Text("Shuffle", fontSize = 30.sp)
                    }
                }
                Column {
                    for (i in 1..shuffledList.size / 3) {
                        LazyRow {
                            items(3) {
                                StarWarsCard(
                                    name = shuffledList[3 * (i - 1) + it].name,
                                    imageId = shuffledList[3 * (i - 1) + it].imageId
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StarWarsCard(name: String, imageId: Int) {
    var isExpanded by remember { mutableStateOf(false) }
    val imageSize = if (isExpanded) 250.dp else 150.dp
    Card(
        modifier = Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .padding(10.dp)
            .width(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!isExpanded) {
                Row {
                    Text(
                        text = name,
                        fontSize = 26.sp,
                        color = Color(0xFF696969)
                    )
                }
            }
            Image(
                modifier = Modifier.size(imageSize),
                painter = painterResource(imageId),
                contentDescription = ""
            )
        }
    }
}