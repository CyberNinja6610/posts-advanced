package ru.netology.service

import ru.netology.entity.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Long = 0

    fun reset() {
        posts = emptyArray();
    }

    fun post(post: Post): Post {
        uniqueId++;
        val postWithId = post.copy(id = uniqueId);
        posts += postWithId;
        return posts.last();
    }

    fun update(post: Post): Boolean {
        val index = (posts.indices).firstOrNull { i: Int -> post.id == posts[i].id }
        if (index === null) {
            return false
        }
        val oldPost = posts[index]
        val newPost = oldPost.copy(id = oldPost.id, ownerId = oldPost.ownerId, date = oldPost.date)
        posts[index] = newPost
        return true
    }
}