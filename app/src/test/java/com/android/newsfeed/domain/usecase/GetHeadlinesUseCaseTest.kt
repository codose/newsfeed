package com.android.newsfeed.domain.usecase

import com.android.newsfeed.data.model.HeadlineResponse
import com.android.newsfeed.data.repository.ArticleLocalRepository
import com.android.newsfeed.data.repository.ArticleRemoteRepository
import com.android.newsfeed.domain.mapper.ArticleMapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GetHeadlinesUseCaseTest {

    private lateinit var underTest: GetHeadlinesUseCase

    @MockK
    private lateinit var articleLocalRepository: ArticleLocalRepository

    @MockK
    private lateinit var articleRemoteRepository: ArticleRemoteRepository

    private val articleMapper = ArticleMapper()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = GetHeadlinesUseCase(
            articleLocalRepository = articleLocalRepository,
            articleRemoteRepository = articleRemoteRepository,
            articleMapper = articleMapper
        )
    }

    @Test
    fun `given when getHeadlines is executed, and remote call is successful verify that the required methods are called`() = runTest {
        coEvery { articleLocalRepository.getArticles() } returns flowOf(listOf())
        coEvery { articleRemoteRepository.getHeadlines() } returns HeadlineResponse(listOf(), "Success", 99)

        underTest.execute().collect()

        coVerifySequence {
            articleRemoteRepository.getHeadlines()

            articleLocalRepository.insertArticles(any())

            articleLocalRepository.getArticles()
        }
    }

    @Test
    fun `given when getHeadlines is executed, and remote call is not successful, verify that the articles is fetched from cache`() = runTest {
        coEvery { articleLocalRepository.getArticles() } returns flowOf(listOf())
        coEvery { articleRemoteRepository.getHeadlines() } throws Exception("An Error occurred")

        underTest.execute().collect()

        coVerifySequence {
            articleRemoteRepository.getHeadlines()

            articleLocalRepository.getArticles()
        }

        coVerify(exactly = 0) {
            articleLocalRepository.insertArticles(any())
        }
    }
}
