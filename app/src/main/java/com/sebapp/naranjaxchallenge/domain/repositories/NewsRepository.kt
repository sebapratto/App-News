package com.sebapp.naranjaxchallenge.domain.repositories

import com.sebapp.naranjaxchallenge.data.network.ApiClient
import com.sebapp.naranjaxchallenge.domain.model.NewsDetailModel
import com.sebapp.naranjaxchallenge.domain.model.NewsDetailResult
import com.sebapp.naranjaxchallenge.domain.model.NewsModel
import com.sebapp.naranjaxchallenge.domain.model.NewsResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

class NewsRepository(
    private val newsApi: ApiClient
){

    fun getNewsById(newsId: String): Flow<NewsDetailModel?> = flow {
        val response = newsApi.getItemNews(newsId)
        if (response.isSuccessful) {
            val news: NewsDetailModel? = response.body()
            emit(news)
        }

    }.catch { e ->
        e.printStackTrace()
    }

    fun getNews(
        query: String
    ): Flow<List<NewsModel>?> = flow {

        val response = newsApi.getAllNews("query")
        if (response.isSuccessful) {
            val newsList: List<NewsModel>? = response.body()
            emit(newsList)
        }


    }.catch { e ->
        e.printStackTrace()
    }



}