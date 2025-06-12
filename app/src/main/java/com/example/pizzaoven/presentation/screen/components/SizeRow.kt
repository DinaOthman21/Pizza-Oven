package com.example.pizzaoven.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SizeRow(
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .shadow(4.dp, shape = CircleShape, clip = false)
                .clip(CircleShape)
                .background(Color.White)
                .align(Alignment.Center)
        )
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .height(45.dp),
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SizeItem(
                size = "S",
                modifier = Modifier
                    .clip(CircleShape)
            )
            SizeItem(
                size = "M",
                modifier = Modifier
                    .clip(CircleShape)
            )
            SizeItem(
                size = "L",
                modifier = Modifier
                    .clip(CircleShape)
            )

        }
    }
}


@Composable
fun SizeItem(
    size: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = size,
        fontSize = 25.sp,
        color = Color.Black,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}