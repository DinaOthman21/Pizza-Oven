package com.example.pizzaoven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.pizzaoven.presentation.view_model.PizzaViewModel
import com.example.pizzaoven.ui.theme.PizzaOvenTheme
import com.example.pizzaoven.presentation.screen.PizzaScreen


class MainActivity : ComponentActivity() {
    private val viewModel : PizzaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaOvenTheme {
                PizzaScreen(viewModel = viewModel)
            }
        }
    }
}

