package com.android.newsfeed.data.model

import com.google.gson.annotations.SerializedName

data class HeadlineResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
