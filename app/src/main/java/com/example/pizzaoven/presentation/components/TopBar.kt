package com.example.pizzaoven.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.R
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "back icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Black.copy(alpha = .7f)
        )
        Text(
            text = "Pizza",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Icon(
            painter = painterResource(id = R.drawable.favorite),
            contentDescription = "icon favorite",
        )
    }

}

@Composable
@Preview(showBackground = true)
fun TopBarPreview(){
     TopBar()
}