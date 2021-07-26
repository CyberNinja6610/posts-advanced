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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Post) return false

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (copyright != other.copyright) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (views != other.views) return false
        if (postType != other.postType) return false
        if (postSource != other.postSource) return false
        if (geo != other.geo) return false
        if (canPin != other.canPin) return false
        if (caDelete != other.caDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (postponedId != other.postponedId) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + ownerId.hashCode()
        result = 31 * result + fromId.hashCode()
        result = 31 * result + createdBy.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId.hashCode()
        result = 31 * result + replyPostId.hashCode()
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + (copyright?.hashCode() ?: 0)
        result = 31 * result + likes.hashCode()
        result = 31 * result + reposts.hashCode()
        result = 31 * result + (views?.hashCode() ?: 0)
        result = 31 * result + postType.hashCode()
        result = 31 * result + (postSource?.hashCode() ?: 0)
        result = 31 * result + (geo?.hashCode() ?: 0)
        result = 31 * result + canPin.hashCode()
        result = 31 * result + caDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + postponedId.hashCode()
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}
