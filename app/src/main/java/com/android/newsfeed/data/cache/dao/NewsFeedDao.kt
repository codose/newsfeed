package com.android.newsfeed.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.newsfeed.data.cache.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsFeedDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Query("DELETE FROM article_entity")
    suspend fun clearDatabase()

    @Query("SELECT * FROM article_entity")
    fun getNewsFeed(): Flow<List<ArticleEntity>>
}
