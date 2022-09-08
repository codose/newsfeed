package com.android.newsfeed.data.api

import com.android.newsfeed.BuildConfig
import com.android.newsfeed.data.model.HeadlineResponse
import com.android.newsfeed.utils.Constants.DEFAULT_COUNTRY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsFeedApi {

    @GET("v2/top-headlines")
    suspend fun getHeadline(
        @Query("country") country: String = DEFAULT_COUNTRY,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): HeadlineResponse
}
