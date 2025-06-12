package com.example.pizzaoven.presentation.screen.components

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
    onIngredientClick: (Int) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(ingredients.size) { index ->
            val ingredient = ingredients[index]
            IngredientItem(
                imageRes = painterResource( ingredient.image),
                isSelected = ingredient.isSelected,
                onClick = { onIngredientClick(index) },
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
        modifier = modifier.size(70.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) green.copy(alpha = .2f) else Color.Transparent
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