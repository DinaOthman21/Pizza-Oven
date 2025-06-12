package com.example.pizzaoven.presentation.state

import com.example.pizzaoven.model.Dropping
import com.example.pizzaoven.model.Pizza

data class PizzaScreenState(
    val pizzas: List<Pizza> = emptyList(),
    val selectedPizzaIndex: Int = 0,
    val dropping: List<Dropping> = emptyList(),
    val totalPrice: Int = 0
)
