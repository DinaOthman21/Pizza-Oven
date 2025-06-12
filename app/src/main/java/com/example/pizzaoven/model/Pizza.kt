package com.example.pizzaoven.model

data class Pizza(
    val image: Int,
    val size: PizzaSize = PizzaSize.M,
    val dropping: List<Dropping>,
    val price: Int
) {
    val totalPrice: Int
        get() = price + dropping.filter { it.isSelected }.sumOf { it.price } + size.price
}