package com.android.newsfeed.data.repository

import com.android.newsfeed.data.cache.dao.NewsFeedDao
import com.android.newsfeed.data.cache.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ArticleLocalRepository {
    fun getArticles(): Flow<List<ArticleEntity>>
    suspend fun insertArticles(articles: List<ArticleEntity>)
}

class ArticleLocalRepositoryImpl @Inject constructor(
    private val newsFeedDao: NewsFeedDao
) : ArticleLocalRepository {
    override fun getArticles(): Flow<List<ArticleEntity>> = newsFeedDao.getNewsFeed()

    override suspend fun insertArticles(articles: List<ArticleEntity>) {
        if (articles.isNotEmpty()) {
            newsFeedDao.clearDatabase()
        }
        newsFeedDao.insertArticles(articles)
    }
}
