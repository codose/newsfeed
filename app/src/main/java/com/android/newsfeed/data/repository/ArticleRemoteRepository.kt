package com.android.newsfeed.data.repository

import com.android.newsfeed.data.model.HeadlineResponse

interface ArticleRemoteRepository {
    suspend fun getHeadlines(): HeadlineResponse
}
