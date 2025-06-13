package com.example.pizzaoven.model

data class Pizza(
    val image: Int,
    val size: PizzaSize = PizzaSize.M,
    val dropping: List<Dropping>,
    val price: Int,
    val selectedDroppings: List<Dropping> = emptyList()
) {
    val totalPrice: Int
        get() = price + selectedDroppings.sumOf { it.price } + size.price
}