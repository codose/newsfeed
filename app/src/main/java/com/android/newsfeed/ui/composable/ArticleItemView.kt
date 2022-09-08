package com.android.newsfeed.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.android.newsfeed.domain.model.ArticleItem

@ExperimentalCoilApi
@Composable
fun ArticleItemView(
    article: ArticleItem,
    onClicked: (ArticleItem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClicked(article)
            }
            .wrapContentHeight(),
    ) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp),
                painter = rememberAsyncImagePainter(article.urlToImage),
                contentDescription = "Article Image",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .background(color = Color.Black.copy(alpha = 0.4f))
            )

            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = article.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = article.author ?: article.source,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
        }
    }
}
