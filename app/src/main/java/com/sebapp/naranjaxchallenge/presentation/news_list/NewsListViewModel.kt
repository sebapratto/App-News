package com.sebapp.naranjaxchallenge.presentation.news_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebapp.naranjaxchallenge.domain.model.NewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

@HiltViewModel
class NoteListViewModel
@Inject
constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
): ViewModel() {

    private var _newsList = MutableStateFlow<List<NewsModel>>(emptyList())
    val noteList: StateFlow<List<NewsModel>> = _newsList

    private var _darkMode = MutableStateFlow<Boolean>(false)
    val darkMode: StateFlow<Boolean> = _darkMode

    private var _linearLayoutMode = MutableStateFlow<Boolean>(true)
    val linearLayoutMode: StateFlow<Boolean> = _linearLayoutMode

    private var _searchQuery = MutableStateFlow("")

    init {
        getNotes()
        getSettings()
    }

    fun getNotes() {
        newsRepository.getNotes(_searchQuery.value).onEach { newsList ->
            _newsList.value = newsList
        }.launchIn(viewModelScope)

    }

    private fun getSettings() {
        settingsRepository.readDarkModeValue().onEach { isDarkMode ->
            _darkMode.value = isDarkMode
        }.launchIn(viewModelScope)

        settingsRepository.readNotesLayoutValue().onEach { isLinearLayoutMode ->
            _linearLayoutMode.value = isLinearLayoutMode
        }.launchIn(viewModelScope)
    }

    fun updateQuery(newQuery: String) {
        _searchQuery.value = newQuery
        getNotes()
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            settingsRepository.toggleDarkMode()
        }
    }

    fun toggleLayoutMode() {
        viewModelScope.launch {
            settingsRepository.toggleNotesLayout()
        }
    }

}