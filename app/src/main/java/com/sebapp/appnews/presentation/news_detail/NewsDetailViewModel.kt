package com.sebapp.appnews.presentation.news_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebapp.appnews.domain.model.ContentItem
import com.sebapp.appnews.domain.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   20,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

@HiltViewModel
class NewsDetailViewModel
@Inject
constructor(
    private val newsRepository: NewsRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _news = MutableStateFlow<ContentItem?>(null)
    val news: StateFlow<ContentItem?> = _news


    init {
        savedStateHandle.get<String>("newsId")?.let { apiUrl ->
            getNewsById(apiUrl)
        }
    }

    private fun getNewsById(newsId: String) {
        newsRepository.getNewsById(newsId).onEach { news ->
            _news.value = news
        }.launchIn(viewModelScope)
    }


}