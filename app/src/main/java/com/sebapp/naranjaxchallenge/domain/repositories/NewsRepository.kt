package com.sebapp.naranjaxchallenge.domain.repositories

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sebapp.naranjaxchallenge.data.network.ApiClient
import com.sebapp.naranjaxchallenge.domain.model.NewsDetailModel
import com.sebapp.naranjaxchallenge.domain.model.News
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

//    fun getNewsById(newsId: String): Flow<NewsDetailModel?> = flow {
//        val response = newsApi.getItemNews(newsId)
//        if (response.isSuccessful) {
//            val news: NewsDetailModel? = response.body()
//            emit(news)
//        }
//
//    }.catch { e ->
//        e.printStackTrace()
//    }

    fun getNews(
    ): Flow<List<News>?> = flow {
        val response = newsApi.getAllNews()

        val newsList: List<News>? = response.body()
        emit(newsList)

//        if (response.isSuccessful) {
//            val newsList: List<News>? = response.body()
//            emit(newsList)
//        }


    }.catch { e ->
        e.printStackTrace()
    }



}