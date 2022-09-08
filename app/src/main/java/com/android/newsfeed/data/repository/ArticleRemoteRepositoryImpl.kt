package com.android.newsfeed.data.repository

import com.android.newsfeed.data.api.NewsFeedApi
import com.android.newsfeed.data.model.HeadlineResponse
import javax.inject.Inject

class ArticleRemoteRepositoryImpl @Inject constructor(
    private val newsFeedApi: NewsFeedApi,
) : ArticleRemoteRepository {
    override suspend fun getHeadlines(): HeadlineResponse {
        return newsFeedApi.getHeadline()
    }
}
