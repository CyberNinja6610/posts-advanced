package ru.netology.entity

data class Post(
    val id: Long?,
    val ownerId: Long,
    val fromId: Long,
    val createdBy: Long,
    val date: Long = System.currentTimeMillis() / 1000,
    val text: String,
    val replyOwnerId: Long,
    val replyPostId: Long,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val postType: String,
    val canPin: Boolean = true,
    val caDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Long
)
