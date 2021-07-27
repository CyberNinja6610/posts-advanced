package ru.netology.entity

import ru.netology.entity.attachment.Attachment

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
    val copyright: Copyright?,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views?,
    val postType: String,
    val postSource: PostSource?,
    val geo: Geo?,
    val canPin: Boolean,
    val caDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Long,
    val attachments: Array<Attachment> = emptyArray(),
)
