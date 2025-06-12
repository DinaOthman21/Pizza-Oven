package com.example.pizzaoven.presentation.screen.components

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.model.PizzaSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip


@Composable
fun SizeRow(
    selectedSize: PizzaSize,
    onItemClick: (PizzaSize) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundOffsetX by animateDpAsState(
        targetValue = when (selectedSize) {
            PizzaSize.S -> (-90).dp
            PizzaSize.M -> 0.dp
            PizzaSize.L -> 92.dp
        },
        animationSpec = tween(durationMillis = 400, easing = EaseInOutCubic),
        label = "backgroundOffset"
    )
    Box {
        Box(
            modifier = modifier
                .size(45.dp)
                .offset(x = backgroundOffsetX)
                .shadow(4.dp, shape = CircleShape, clip = false)
                .background(Color.White, CircleShape)
                .align(Alignment.Center)
        )
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PizzaSize.entries.forEach { size ->
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .clickable{onItemClick(size)},
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = size.name,
                        fontSize = 25.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
