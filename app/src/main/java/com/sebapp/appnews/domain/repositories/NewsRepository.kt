package com.sebapp.appnews.domain.repositories

import com.sebapp.appnews.data.network.ApiClient
import com.sebapp.appnews.domain.model.ContentItem
import com.sebapp.appnews.domain.model.Results
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

    /** Get from api */

class NewsRepository(
    private val newsApi: ApiClient
){


    fun getNewsById(
        newsId: String
    ): Flow<ContentItem?> = flow {
        val apiResponse = newsApi.getItemNews(newsId)
        apiResponse.body()?.response?.content?.let {
            emit(it)
        }

    }.catch { e ->
        e.printStackTrace()
    }

    fun getNews(
    ): Flow<List<Results>> = flow {

        val apiResponse = newsApi.getAllNews()
        apiResponse.body()?.response?.results?.let {
            emit(it)
        }

    }.catch { e ->
        e.printStackTrace()
    }



}