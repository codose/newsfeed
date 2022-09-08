package com.android.newsfeed.ui.viewmodel

import com.android.newsfeed.TestDispatcherProvider
import com.android.newsfeed.domain.usecase.GetHeadlinesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ArticlesViewModelTest {

    private lateinit var underTest: ArticlesViewModel

    @MockK
    private lateinit var getHeadlinesUseCase: GetHeadlinesUseCase

    private val testDispatcherProvider = TestDispatcherProvider()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = ArticlesViewModel(
            getHeadlinesUseCase,
            testDispatcherProvider
        )
    }

    @Test
    fun `given when getArticles is call, verify that the required methods are called`() = runTest {
        coEvery { getHeadlinesUseCase.execute() } returns flowOf()
        underTest.getArticles()

        coVerify { getHeadlinesUseCase.execute() }
    }
}
