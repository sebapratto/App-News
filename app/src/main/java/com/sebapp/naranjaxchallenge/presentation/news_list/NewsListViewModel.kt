package com.sebapp.naranjaxchallenge.presentation.news_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebapp.naranjaxchallenge.domain.model.News
import com.sebapp.naranjaxchallenge.domain.repositories.NewsRepository
import com.sebapp.naranjaxchallenge.domain.repositories.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

@HiltViewModel
class NewsListViewModel
@Inject
constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
): ViewModel() {

    private var _newsList = MutableStateFlow<List<News>>(emptyList())
    val newsList: StateFlow<List<News>> = _newsList

    private var _darkMode = MutableStateFlow<Boolean>(false)
    val darkMode: StateFlow<Boolean> = _darkMode

    private var _linearLayoutMode = MutableStateFlow<Boolean>(true)
    val linearLayoutMode: StateFlow<Boolean> = _linearLayoutMode


    init {
        getNews()
        getSettings()
    }

    fun getNews() {
        newsRepository.getNews().onEach { newsList ->
            if (newsList != null) {
                _newsList.value = newsList
            }

        }.launchIn(viewModelScope)

    }

    private fun getSettings() {
        settingsRepository.readDarkModeValue().onEach { isDarkMode ->
            _darkMode.value = isDarkMode
        }.launchIn(viewModelScope)

        settingsRepository.readLayoutValue().onEach { isLinearLayoutMode ->
            _linearLayoutMode.value = isLinearLayoutMode
        }.launchIn(viewModelScope)
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            settingsRepository.toggleDarkMode()
        }
    }

    fun toggleLayoutMode() {
        viewModelScope.launch {
            settingsRepository.toggleLayout()
        }
    }

}