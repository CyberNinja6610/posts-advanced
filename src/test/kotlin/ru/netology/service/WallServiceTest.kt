package ru.netology.service

import org.junit.Assert.*
import ru.netology.entity.Comments
import ru.netology.entity.Likes
import ru.netology.entity.Post
import ru.netology.entity.Reposts

class WallServiceTest {

    @org.junit.Test
    fun post() {

        val comments = Comments();

        val ownerId: Long = 2
        val fromId: Long = 3
        val createdBy: Long = 4
        val date: Long = System.currentTimeMillis() / 1000
        val text = "Текст например"
        val likes = Likes()
        val reposts = Reposts()
        val postType = "post"
        val id = 0L
        val caDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val canPin = false
        val friendsOnly = false
        val postponedId = 0L
        val replyOwnerId = 0L
        val replyPostId = 0L

        var post = Post(
            id = id,
            ownerId = ownerId,
            comments = comments,
            fromId = fromId,
            createdBy = createdBy,
            likes = likes,
            text = text,
            date = date,
            reposts = reposts,
            postType = postType,
            caDelete = caDelete,
            canEdit = canEdit,
            isPinned = isPinned,
            markedAsAds = markedAsAds,
            isFavorite = isFavorite,
            canPin = canPin,
            friendsOnly = friendsOnly,
            postponedId = postponedId,
            replyOwnerId = replyOwnerId,
            replyPostId = replyPostId
        )

        WallService.post(post);
        assertEquals(Post::class.java, post::class.java)
    }
}