package ru.netology.entity.attachment

data class PrettyCard(
    val cardId: String,
    val linkUrl: String,
    val title: String,
    val images: Array<Image> = emptyArray(),
    val price: String,
    val priceOld:String
)