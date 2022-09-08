package com.android.newsfeed.di

import com.android.newsfeed.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindArticleRemoteRepository(articleRemoteRepositoryImpl: ArticleRemoteRepositoryImpl): ArticleRemoteRepository

    @Binds
    abstract fun bindArticleLocalRepository(articleLocalRepositoryImpl: ArticleLocalRepositoryImpl): ArticleLocalRepository
}
