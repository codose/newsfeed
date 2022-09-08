package com.android.newsfeed.di

import android.content.Context
import androidx.room.Room
import com.android.newsfeed.data.cache.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return Room.databaseBuilder(context, ArticleDatabase::class.java, "article_database").build()
    }

    @Provides
    @Singleton
    fun providesDao(articleDatabase: ArticleDatabase) = articleDatabase.newsFeedDao()
}
