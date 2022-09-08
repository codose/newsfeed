package com.android.newsfeed.data.repository

import com.android.newsfeed.data.cache.dao.NewsFeedDao
import com.android.newsfeed.data.cache.entity.ArticleEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest

import org.junit.Before
import org.junit.Test

class ArticleLocalRepositoryImplTest {

    private lateinit var underTest: ArticleLocalRepositoryImpl
    private val articleDao = mockk<NewsFeedDao>()

    @Before
    fun setUp() {
        underTest = ArticleLocalRepositoryImpl(articleDao)
    }

    @Test
    fun `given when insert articles is called and articles is not empty, verify that database is cleared`() =
        runTest {
            coEvery { articleDao.clearDatabase() } returns Unit
            coEvery { articleDao.insertArticles(any()) } returns Unit

            underTest.insertArticles(
                listOf(
                    ArticleEntity(
                        id = 0,
                        author = null,
                        content = null,
                        description = "",
                        publishedAt = "",
                        source = "",
                        title = "",
                        url = "",
                        urlToImage = ""
                    )
                )
            )

            coVerify { articleDao.clearDatabase() }
            coVerify { articleDao.insertArticles(any()) }
        }

    @Test
    fun `given when insert articles is called and articles is empty, verify that database is not cleared`() =
        runTest {
            coEvery { articleDao.clearDatabase() } returns Unit
            coEvery { articleDao.insertArticles(any()) } returns Unit

            underTest.insertArticles(
                listOf()
            )

            coVerify(exactly = 0) { articleDao.clearDatabase() }
            coVerify { articleDao.insertArticles(any()) }
        }
}
