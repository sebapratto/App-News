package com.sebapp.naranjaxchallenge.data.network

import com.sebapp.naranjaxchallenge.domain.model.NewsDetailModel
import com.sebapp.naranjaxchallenge.domain.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */
interface ApiClient {

    @GET("/search?api-key={key}")
    suspend fun getAllNews(): Response<List<News>>

    @GET("{url}")
    suspend fun getItemNews(@Path("url") url: String): Response<NewsDetailModel>

}