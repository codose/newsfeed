package com.android.newsfeed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.newsfeed.domain.usecase.State
import com.android.newsfeed.ui.composable.ErrorPage
import com.android.newsfeed.ui.composable.FullScreenProgress
import com.android.newsfeed.ui.composable.ArticlesList
import com.android.newsfeed.ui.viewmodel.ArticlesViewModel
import com.android.newsfeed.utils.getActivity
import com.android.newsfeed.utils.openChromeTab
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MainScreen(articlesViewModel: ArticlesViewModel) {
    val data by articlesViewModel.state.collectAsState()
    val activity = LocalContext.current.getActivity()

    Column(Modifier) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "NewsFeed",
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )
        }

        when (data) {
            is State.Failure -> {
                ErrorPage(
                    message = (data as State.Failure).message,
                    modifier = Modifier.fillMaxSize()
                ) {
                    articlesViewModel.getArticles()
                }
            }
            State.Loading -> {
                FullScreenProgress(modifier = Modifier.fillMaxSize())
            }
            is State.Success -> {
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing = data is State.Loading),
                    onRefresh = { articlesViewModel.getArticles() }
                ) {
                    ArticlesList(listItems = (data as State.Success).data) { article ->
                        activity?.openChromeTab(article.url)
                    }
                }
            }
        }
    }
}
