package com.android.newsfeed.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_entity")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val author: String?,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
