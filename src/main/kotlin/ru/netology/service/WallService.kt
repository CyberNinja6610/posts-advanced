package ru.netology.service

import ru.netology.Reason
import ru.netology.entity.Comment
import ru.netology.entity.Post
import ru.netology.entity.ReportComment
import ru.netology.exception.CommentNotFoundException
import ru.netology.exception.PostNotFoundException
import ru.netology.exception.ReasonNotFoundException
import java.util.*

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()
    private var uniqueId: Long = 0


    fun reset() {
        posts = emptyArray()
    }

    fun post(post: Post): Post {
        uniqueId++
        val postWithId = post.copy(id = uniqueId)
        posts += postWithId
        return posts.last()
    }

    private fun findPostIndexById(id: Long): Int? {
        return (posts.indices).firstOrNull { i: Int -> id == posts[i].id }
    }

    private fun findCommentIndexByGuid(guid: String): Int? {
        return (comments.indices).firstOrNull { i: Int -> guid == comments[i].guid }
    }

    private fun findPostById(id: Long): Post? {
        return posts.firstOrNull { post -> id == post.id }
    }

    private fun findCommentByGuid(guid: String): Comment? {
        return comments.firstOrNull { comment -> guid == comment.guid }
    }

    fun update(post: Post): Boolean {
        val index = findPostIndexById(post.id)
        if (index === null) {
            return false
        }
        val oldPost = posts[index]
        val newPost = oldPost.copy(id = oldPost.id, ownerId = oldPost.ownerId, date = oldPost.date)
        posts[index] = newPost
        return true
    }

    fun createComment(comment: Comment): Comment {
        val postId =
            findPostById(comment.postId)?.id ?: throw PostNotFoundException("no post with id ${comment.postId}")
        val newComment = comment.copy(postId = postId, guid = generateUUID())
        comments += newComment
        return comments.last()
    }

    private fun checkReason(reason: Int): Reason? {
        return Reason.values().firstOrNull { curReason -> curReason.type == reason }
    }

    fun createReportComment(report: ReportComment): ReportComment {
        checkReason(report.reason) ?: throw ReasonNotFoundException("no reason with type ${report.reason}")
        val commentGuid = findCommentByGuid(report.commentId)?.guid
            ?: throw CommentNotFoundException("no comment with id ${report.commentId}")
        val newReport = report.copy(commentId = commentGuid)
        reportComments += newReport
        return reportComments.last()
    }

    private fun generateUUID(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }
}