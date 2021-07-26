package ru.netology.entity.attachment

data class Note(

    val id: Long,
    val ownerId: Long,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String,
    val privacyView: Array<String>,
    val privacyComment: Array<String>,
    val canComment: Boolean,
    val textWiki: Long,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Note) return false

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (title != other.title) return false
        if (text != other.text) return false
        if (date != other.date) return false
        if (comments != other.comments) return false
        if (readComments != other.readComments) return false
        if (viewUrl != other.viewUrl) return false
        if (!privacyView.contentEquals(other.privacyView)) return false
        if (!privacyComment.contentEquals(other.privacyComment)) return false
        if (canComment != other.canComment) return false
        if (textWiki != other.textWiki) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + ownerId.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + date
        result = 31 * result + comments
        result = 31 * result + readComments
        result = 31 * result + viewUrl.hashCode()
        result = 31 * result + privacyView.contentHashCode()
        result = 31 * result + privacyComment.contentHashCode()
        result = 31 * result + canComment.hashCode()
        result = 31 * result + textWiki.hashCode()
        return result
    }
}