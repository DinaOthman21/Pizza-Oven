package com.example.pizzaoven.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.R
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.Preview
import com.example.pizzaoven.ui.theme.brown


@Composable
fun PizzaButton(
    modifier: Modifier = Modifier
){
    Button(
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(brown),
        onClick = {}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cart_1),
            contentDescription = "shopping cart",
            modifier = Modifier.padding(start = 8.dp).size(30.dp)
        )
        Text(
            text = "Add to cart",
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp,vertical = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PizzaButtonPreview(){
    PizzaButton()
}