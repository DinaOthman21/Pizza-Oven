package com.example.pizzaoven.presentation.screen.components

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.model.Dropping
import com.example.pizzaoven.ui.theme.green


@Composable
fun IngredientsRow(
    ingredients: List<Dropping>,
    onIngredientClick: (Dropping) -> Unit,
    selectedDroppings: List<Dropping>
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(ingredients.size) { index ->
            val ingredient = ingredients[index]
            val isSelected = selectedDroppings.any { it.index == ingredient.index }
            IngredientItem(
                imageRes = painterResource( ingredient.image),
                isSelected = isSelected,
                onClick = {  onIngredientClick(ingredient) },
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    imageRes: Painter,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(60.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFFD8FAE2) else Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Image(
            painter = imageRes,
            contentDescription = "Ingredient Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .padding(12.dp)
        )
    }
}