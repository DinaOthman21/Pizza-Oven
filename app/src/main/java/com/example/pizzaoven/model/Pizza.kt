package com.example.pizzaoven.model

data class Pizza(
    val image: Int,
    val size: PizzaSize,
    val dropping: List<Dropping>,
    val price: Int
)