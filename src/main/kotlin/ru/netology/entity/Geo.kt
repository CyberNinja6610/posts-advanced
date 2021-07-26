package ru.netology.entity

data class Geo(
    val type: String,
    val coordinates: String,
    val place: Place?,
)