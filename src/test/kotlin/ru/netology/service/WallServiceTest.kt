package ru.netology.service

import org.junit.Assert.*
import ru.netology.entity.Comments
import ru.netology.entity.Likes
import ru.netology.entity.Post
import ru.netology.entity.Reposts

class WallServiceTest {

    @org.junit.Test
    fun post() {

        WallService.reset()

        val comments = Comments()

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

        post = WallService.post(post)
        assertNotEquals(0, post.id)
    }

    @org.junit.Test
    fun update_updated() {

        WallService.reset()

        val comments = Comments()

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

        post = WallService.post(post)

        val newText = "Новый текст"
        val newPost = post.copy(text = newText)

        val result = WallService.update(newPost)
        assertTrue(result)
    }

    @org.junit.Test
    fun update_notUpdated() {

        WallService.reset()

        val comments = Comments()

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

        post = WallService.post(post)

        val newText = "Новый текст"
        val fakeId = 10L
        val newPost = post.copy(id = fakeId, text = newText)

        val result = WallService.update(newPost)
        assertFalse(result)
    }
}