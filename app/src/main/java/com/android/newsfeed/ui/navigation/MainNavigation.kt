package com.android.newsfeed.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.newsfeed.ui.screens.DetailsScreen
import com.android.newsfeed.ui.screens.MainScreen
import com.android.newsfeed.ui.viewmodel.ArticlesViewModel

@ExperimentalComposeUiApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.MainScreen.route) {

        composable(route = Routes.MainScreen.route) {
            val articlesViewModel: ArticlesViewModel = hiltViewModel()
            MainScreen(articlesViewModel) { article ->
                navController.navigate(Routes.NewsDetailsScreen.createRoute(article.url))
            }
        }

        composable(
            route = Routes.NewsDetailsScreen.route,
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                }
            )
        ) {
            it.arguments?.getString("url")?.let { url ->
                DetailsScreen(
                    url
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
}
