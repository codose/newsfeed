package com.android.newsfeed.domain.model

data class ArticleItem(
    val id: Long,
    val author: String?,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
