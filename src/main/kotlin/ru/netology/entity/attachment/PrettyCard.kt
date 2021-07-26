package ru.netology.entity.attachment

data class PrettyCard(
    val cardId: String,
    val linkUrl: String,
    val title: String,
    val images: Array<Image> = emptyArray(),
    val price: String,
    val priceOld:String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PrettyCard) return false

        if (cardId != other.cardId) return false
        if (linkUrl != other.linkUrl) return false
        if (title != other.title) return false
        if (!images.contentEquals(other.images)) return false
        if (price != other.price) return false
        if (priceOld != other.priceOld) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cardId.hashCode()
        result = 31 * result + linkUrl.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + images.contentHashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + priceOld.hashCode()
        return result
    }
}