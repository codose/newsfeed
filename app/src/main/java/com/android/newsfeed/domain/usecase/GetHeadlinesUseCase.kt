package com.android.newsfeed.domain.usecase

import com.android.newsfeed.data.repository.ArticleLocalRepository
import com.android.newsfeed.data.repository.ArticleRemoteRepository
import com.android.newsfeed.domain.mapper.ArticleMapper
import com.android.newsfeed.domain.model.ArticleItem
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@ViewModelScoped
class GetHeadlinesUseCase @Inject constructor(
    private val articleRemoteRepository: ArticleRemoteRepository,
    private val articleLocalRepository: ArticleLocalRepository,
    private val articleMapper: ArticleMapper
) {
    suspend fun execute(): Flow<State> = flow {
        emit(State.Loading)
        try {
            val headlineResponse = articleRemoteRepository.getHeadlines()
            val entities = headlineResponse.articles.map {
                articleMapper.mapToEntity(it)
            }
            articleLocalRepository.insertArticles(entities)

            emit(State.Success(entities.map { articleMapper.mapToItem(it) }))
        } catch (e: Exception) {
            Timber.e(e)
            val entities = articleLocalRepository.getArticles().first()

            if (entities.isNotEmpty()) {
                emit(State.Success(entities.map { articleMapper.mapToItem(it) }))
            } else {
                emit(State.Failure("An error occurred!: ${e.message}"))
            }
        }
    }
}

sealed interface State {
    object Loading : State
    data class Success(val data: List<ArticleItem>) : State
    data class Failure(val message: String) : State
}
