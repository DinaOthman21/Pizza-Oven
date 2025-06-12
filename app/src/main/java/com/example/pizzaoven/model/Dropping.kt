package com.example.pizzaoven.model

data class Dropping(
    val index: Int,
    val image: Int,
    val price: Int,
    val ingredients: List<Int>,
    val isSelected: Boolean = false
)