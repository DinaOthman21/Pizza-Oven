
package com.example.pizzaoven.presentation.screen.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.R
import com.example.pizzaoven.model.Pizza
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

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
                .fillMaxWidth(0.7f)
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

                val allIngredients = pizza.selectedDroppings.flatMap { it.ingredients }

                    allIngredients.forEachIndexed { index, ingredientImage ->
                        AnimatedIngredient(
                            image = ingredientImage,
                            pizzaSize = pizza.size.scale,
                            index = index
                        )
                    }
            }
        }
    }
}

@Composable
fun AnimatedIngredient(
    image: Int,
    pizzaSize: Float,
    index: Int
) {
    var visible by remember { mutableStateOf(false) }
    val startRadius = 300f
    val angle = remember(index) { Random.nextDouble(0.0, 360.0) }
    val startOffsetX = remember(index) { (startRadius * cos(Math.toRadians(angle))).toFloat() }
    val startOffsetY = remember(index) { (startRadius * sin(Math.toRadians(angle))).toFloat() }
    val endRadius = remember(index) { Random.nextDouble(30.0, 90.0 * pizzaSize).toFloat() }
    val jitterX = remember(index) { Random.nextDouble(-10.0, 10.0).toFloat() }
    val jitterY = remember(index) { Random.nextDouble(-10.0, 10.0).toFloat() }
    val endOffsetX = remember(index) { (endRadius * cos(Math.toRadians(angle))).toFloat() + jitterX }
    val endOffsetY = remember(index) { (endRadius * sin(Math.toRadians(angle))).toFloat() + jitterY }
    val offsetX by animateFloatAsState(
        targetValue = if (visible) endOffsetX else startOffsetX,
        animationSpec = tween(400 + index * 50)
    )
    val offsetY by animateFloatAsState(
        targetValue = if (visible) endOffsetY else startOffsetY,
        animationSpec = tween(400 + index * 50)
    )
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(800)
    )

    val scale by animateFloatAsState(
        targetValue = if (visible) 0.3f else 0f,
        animationSpec = tween(800)
    )

    LaunchedEffect(Unit) {
        visible = true
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .offset(x = offsetX.dp, y = offsetY.dp)
            .scale(scale)
            .graphicsLayer { this.alpha = alpha }
    )
}


/*
@Composable
fun AnimatedIngredient(
    image: Int,
    pizzaSize: Float,
    index: Int
) {
    var visible by remember { mutableStateOf(false) }

    val maxRadius = (100 * pizzaSize).toInt()
    val randomAngle = remember(index) { Random.nextDouble(0.0, 360.0) }
    val randomRadius = remember(index) { Random.nextInt(0, maxRadius) }

    val offsetX = (randomRadius * kotlin.math.cos(Math.toRadians(randomAngle))).toInt()
    val offsetY = (randomRadius * kotlin.math.sin(Math.toRadians(randomAngle))).toInt()

    LaunchedEffect(Unit) {
        visible = true
    }
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(initialScale = 3f, animationSpec = tween(600)) + fadeIn(tween(600))
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .offset(x = offsetX.dp, y = offsetY.dp)
                .scale(0.3f)
        )
    }
}
*/
