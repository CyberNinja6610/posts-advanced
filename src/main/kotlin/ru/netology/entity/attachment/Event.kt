package ru.netology.entity.attachment

data class Event(

    val id: Long = 0,
    val time: Long = System.currentTimeMillis() / 1000,
    val memberStatus: Int = 0,
    val isFavorite: Boolean = false,
    val address: String,
    val text: String,
    val button_text: String,
    val friends: Array<String>,

    )