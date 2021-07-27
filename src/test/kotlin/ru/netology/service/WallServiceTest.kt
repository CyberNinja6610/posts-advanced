package ru.netology.service

import org.junit.Assert.*
import ru.netology.Reason
import ru.netology.entity.*
import ru.netology.entity.attachment.*
import ru.netology.exception.CommentNotFoundException
import ru.netology.exception.PostNotFoundException
import ru.netology.exception.ReasonNotFoundException

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

        val attachments = emptyArray<Attachment>()
        val page = Page(id = 0, groupId = 0, "Страничка")
        val attachment: Attachment = PageAttachment(page)
        attachments.plus(attachment)

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
            replyPostId = replyPostId,
            copyright = null,
            geo = null,
            postSource = null,
            views = null,
            attachments = attachments
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

        val attachments = emptyArray<Attachment>()
        val page = Page(id = 0, groupId = 0, "Страничка")
        val attachment: Attachment = PageAttachment(page)
        attachments.plus(attachment)

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
            replyPostId = replyPostId,
            copyright = null,
            geo = null,
            postSource = null,
            views = null,
            attachments = attachments
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

        val attachments = emptyArray<Attachment>()
        val page = Page(id = 0, groupId = 0, "Страничка")
        val attachment: Attachment = PageAttachment(page)
        attachments.plus(attachment)

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
            replyPostId = replyPostId,
            copyright = null,
            geo = null,
            postSource = null,
            views = null,
            attachments = attachments
        )

        post = WallService.post(post)

        val newText = "Новый текст"
        val fakeId = 10L
        val newPost = post.copy(id = fakeId, text = newText)

        val result = WallService.update(newPost)
        assertFalse(result)
    }

    @org.junit.Test
    fun createComment() {

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

        val attachments = emptyArray<Attachment>()
        val page = Page(id = 0, groupId = 0, "Страничка")
        val attachment: Attachment = PageAttachment(page)
        attachments.plus(attachment)

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
            replyPostId = replyPostId,
            copyright = null,
            geo = null,
            postSource = null,
            views = null,
            attachments = attachments
        )

        post = WallService.post(post)

        val message = "Сообщение"
        var comment = Comment(postId = post.id, attachments = null, guid = "", message = message)
        comment = WallService.createComment(comment)
        assertNotEquals(0, comment.postId)
    }

    @org.junit.Test
    fun createComment_NotFounded() {
        assertThrows(PostNotFoundException::class.java) {
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

            val attachments = emptyArray<Attachment>()
            val page = Page(id = 0, groupId = 0, "Страничка")
            val attachment: Attachment = PageAttachment(page)
            attachments.plus(attachment)

            val post = Post(
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
                replyPostId = replyPostId,
                copyright = null,
                geo = null,
                postSource = null,
                views = null,
                attachments = attachments
            )

            WallService.post(post)

            val message = "Сообщение"
            val fakeId = 1231233L
            val comment = Comment(postId = fakeId, attachments = null, guid = "", message = message)
            WallService.createComment(comment = comment)
        }
    }

    @org.junit.Test
    fun createReportComment() {

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

        val attachments = emptyArray<Attachment>()
        val page = Page(id = 0, groupId = 0, "Страничка")
        val attachment: Attachment = PageAttachment(page)
        attachments.plus(attachment)

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
            replyPostId = replyPostId,
            copyright = null,
            geo = null,
            postSource = null,
            views = null,
            attachments = attachments
        )

        post = WallService.post(post)

        val message = "Сообщение"
        var comment = Comment(postId = post.id, attachments = null, guid = "", message = message)
        comment = WallService.createComment(comment)

        var reportComment = ReportComment(commentId = comment.guid, reason = Reason.ABUSE.type)
        reportComment = WallService.createReportComment(reportComment)
        assertEquals(comment.guid, reportComment.commentId)

    }

    @org.junit.Test
    fun createReportComment_reasonNotFound() {
        assertThrows(ReasonNotFoundException::class.java) {
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

            val attachments = emptyArray<Attachment>()
            val page = Page(id = 0, groupId = 0, "Страничка")
            val attachment: Attachment = PageAttachment(page)
            attachments.plus(attachment)

            val post = Post(
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
                replyPostId = replyPostId,
                copyright = null,
                geo = null,
                postSource = null,
                views = null,
                attachments = attachments
            )

            WallService.post(post)

            val message = "Сообщение"
            var comment = Comment(postId = post.id, attachments = null, guid = "", message = message)
            comment = WallService.createComment(comment)

            var fakeReason = 123123
            var reportComment = ReportComment(commentId = comment.guid, reason = fakeReason)
            reportComment = WallService.createReportComment(reportComment)
            assertEquals(comment.guid, reportComment.commentId)
        }
    }

    @org.junit.Test
    fun createReportComment_commentNotFound() {
        assertThrows(CommentNotFoundException::class.java) {
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

            val attachments = emptyArray<Attachment>()
            val page = Page(id = 0, groupId = 0, "Страничка")
            val attachment: Attachment = PageAttachment(page)
            attachments.plus(attachment)

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
                replyPostId = replyPostId,
                copyright = null,
                geo = null,
                postSource = null,
                views = null,
                attachments = attachments
            )

            post = WallService.post(post)

            val message = "Сообщение"
            var comment = Comment(postId = post.id, attachments = null, guid = "", message = message)
            comment = WallService.createComment(comment)

            val fakeGuid = "123123123123"
            var reportComment = ReportComment(commentId = fakeGuid, reason = Reason.ABUSE.type)
            WallService.createReportComment(reportComment)
        }
    }
}