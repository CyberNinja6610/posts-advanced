package ru.netology.entity

data class Comment(
    val ownerId: Long = 0,
    val postId: Long = 0,
    val fromGroup: Long = 0,
    val message: String?,
    val replyToComment: Long = 0,
    val attachments: String?,
    val stickerId: Long = 0,
    val guid: String,
)
