package ru.netology.service

import ru.netology.entity.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Long = 0
        get() = field

    fun post(post: Post): Post {
        uniqueId++;
        val postWithId = post.copy(id = uniqueId);
        posts += postWithId;
        return posts.last();
    }
}