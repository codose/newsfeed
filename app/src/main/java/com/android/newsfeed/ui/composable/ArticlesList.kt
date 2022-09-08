package com.android.newsfeed.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.android.newsfeed.domain.model.ArticleItem

@ExperimentalCoilApi
@Composable
fun ArticlesList(listItems: List<ArticleItem>, onClicked: (ArticleItem) -> Unit) {
    LazyColumn {
        items(listItems) { result ->
            result.let {
                ArticleItemView(it, onClicked)
                Spacer(Modifier.height(4.dp))
            }
        }
    }
}
