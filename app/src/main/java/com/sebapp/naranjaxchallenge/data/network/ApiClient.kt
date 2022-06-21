package com.sebapp.naranjaxchallenge.data.network


import com.sebapp.naranjaxchallenge.Constants.ALL_NEWS
import com.sebapp.naranjaxchallenge.Constants.API_KEY
import com.sebapp.naranjaxchallenge.Constants.ITEM_FILTER
import com.sebapp.naranjaxchallenge.domain.model.NewsResponse
import com.sebapp.naranjaxchallenge.domain.model.NewsDetailResponse
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

    @GET("${ALL_NEWS}&${API_KEY}")
    suspend fun getAllNews(): Response<NewsResponse>

    @GET("{url}${ITEM_FILTER}&${API_KEY}")
    suspend fun getItemNews(@Path("url",encoded = true) url: String): Response<NewsDetailResponse>

}