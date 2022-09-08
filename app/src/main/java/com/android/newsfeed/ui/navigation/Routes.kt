package com.android.newsfeed.ui.navigation

sealed class Routes(val route: String) {

    object MainScreen : Routes("mainScreen")
    object NewsDetailsScreen : Routes("detailsScreen?details={url}") {
        fun createRoute(url: String) = "detailsScreen?details=$url"
    }
}
