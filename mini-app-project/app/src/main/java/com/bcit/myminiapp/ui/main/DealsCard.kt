package com.bcit.myminiapp.ui.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bcit.myminiapp.data.Deal
import java.text.DateFormat
import java.util.Date

fun cardClicked(
    deal: Deal,
    favouriteList: MutableList<Deal>? = null,
    changeColor: ((Long) -> Unit)? = null
) {
    if (favouriteList != null && !favouriteList.contains(deal) && changeColor != null) {
        favouriteList.add(deal)
        changeColor(0xFFE00A0A)
    }
}

@Composable
fun DealsCard(
    deal: Deal,
    favouriteList: MutableList<Deal>? = null,
    changeColor: ((Long) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .clickable { cardClicked(deal, favouriteList, changeColor) }
            .fillMaxWidth()
            .padding(5.dp)
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Row(modifier = Modifier.background(Color(0xFF2C2D52))) {
            Column(modifier = Modifier.width(110.dp)) {
                AsyncImage(
                    deal.image,
                    null,
                    Modifier
                        .height(155.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            DealsCardContent(deal)
        }
    }
}

@Composable
private fun DealsCardContent(deal: Deal) {
    val steamRating = String.format("%.1f", deal.steamRatingPercent.toInt() / 100.0 * 5)
    val releaseDate = DateFormat.getDateInstance().format(Date(deal.releaseDate * 1000L))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Text(
            text = deal.title,
            modifier = Modifier.padding(bottom = 5.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily.Monospace,
            color = Color(0xFFFFFFFF),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append("$${deal.normalPrice}")
                    }
                },
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFFD30909)
            )
            Text(
                "$${deal.salePrice}",
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFFFFFFFF)
            )
            Column(
                modifier = Modifier
                    .background(Color(0xFF10AA12))
                    .padding(vertical = 4.dp, horizontal = 8.dp),
            ) {
                Text(
                    text = "-${deal.savings.split(".")[0]}%",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFFFFFFFF)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (deal.steamRatingPercent != "0" && deal.steamRatingCount != "0") {
                    "$steamRating/5 (${deal.steamRatingCount} reviews)"
                } else "No reviews",
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFFFFFFFF)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (deal.releaseDate != 0L) "Release Date: $releaseDate" else "Release Date: N/A",
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFFFFFFFF)
            )
        }
    }
}