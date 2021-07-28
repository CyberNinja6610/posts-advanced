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
)