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

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Event) return false

        if (id != other.id) return false
        if (time != other.time) return false
        if (memberStatus != other.memberStatus) return false
        if (isFavorite != other.isFavorite) return false
        if (address != other.address) return false
        if (text != other.text) return false
        if (button_text != other.button_text) return false
        if (!friends.contentEquals(other.friends)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = (31 * result + time).toInt()
        result = 31 * result + memberStatus
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + button_text.hashCode()
        result = 31 * result + friends.contentHashCode()
        return result
    }
}