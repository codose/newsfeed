package com.android.newsfeed.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.newsfeed.data.cache.dao.NewsFeedDao
import com.android.newsfeed.data.cache.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 3, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun newsFeedDao(): NewsFeedDao
}
