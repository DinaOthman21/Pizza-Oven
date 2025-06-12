package com.example.pizzaoven.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.R
import com.example.pizzaoven.model.Pizza

@Composable
fun PizzaImage(
    modifier: Modifier = Modifier,
    pizzas: List<Pizza>,
    selectedPizzaIndex: Int,
    onPizzaPageChanged: (Int) -> Unit
){
    val pagerState = rememberPagerState(
        initialPage = selectedPizzaIndex,
        pageCount = {pizzas.size}
    )
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPizzaPageChanged(page)
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.plate),
            contentDescription = "Plate image",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.Center)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            val pizza = pizzas[page]
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = pizza.image),
                    contentDescription = "Pizza ${page + 1}",
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .scale(pizza.size.scale)
                )
            }
        }
    }
}