package ru.netology.entity

data class Post(
    val id: Long,
    val ownerId: Long,
    val fromId: Long,
    val createdBy: Long,
    val date: Long,
    val text: String,
    val replyOwnerId: Long,
    val replyPostId: Long,
    val friendsOnly: Boolean,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val postType: String,
    val canPin: Boolean,
    val caDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Long
)
