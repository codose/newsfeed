package com.android.newsfeed.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.android.newsfeed.ui.theme.NewsFeedTheme
import com.android.newsfeed.ui.navigation.MainNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsFeedApp()
        }
    }
}

@OptIn(ExperimentalCoilApi::class, ExperimentalComposeUiApi::class)
@Composable
fun NewsFeedApp() {
    NewsFeedTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MainNavigation()
        }
    }
}
