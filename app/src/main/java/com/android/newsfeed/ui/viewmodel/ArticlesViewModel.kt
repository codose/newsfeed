package com.android.newsfeed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.newsfeed.domain.usecase.GetHeadlinesUseCase
import com.android.newsfeed.domain.usecase.State
import com.android.newsfeed.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getHeadlinesUseCase: GetHeadlinesUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch(dispatchers.io) {
            getHeadlinesUseCase.execute()
                .collect {
                    _state.value = it
                }
        }
    }
}
