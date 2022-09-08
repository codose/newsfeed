package com.android.newsfeed.domain.mapper

import com.android.newsfeed.data.cache.entity.ArticleEntity
import com.android.newsfeed.data.model.*
import com.android.newsfeed.domain.model.ArticleItem
import javax.inject.Inject

class ArticleMapper @Inject constructor() {
    fun mapToEntity(article: Article): ArticleEntity = ArticleEntity(
        author = article.author,
        content = article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        source = article.source.name,
        title = article.title,
        url = article.url,
        urlToImage = article.urlToImage
    )

    fun mapToItem(articleEntity: ArticleEntity) = ArticleItem(
        author = articleEntity.author,
        content = articleEntity.content,
        description = articleEntity.description,
        publishedAt = articleEntity.publishedAt,
        source = articleEntity.source,
        title = articleEntity.title,
        url = articleEntity.url,
        urlToImage = articleEntity.urlToImage,
        id = articleEntity.id
    )
}
