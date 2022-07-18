package com.sebapp.appnews.data.network


import com.sebapp.appnews.Constants.ALL_NEWS
import com.sebapp.appnews.Constants.API_KEY
import com.sebapp.appnews.Constants.ITEM_FILTER
import com.sebapp.appnews.domain.model.NewsResponse
import com.sebapp.appnews.domain.model.NewsDetailResponse
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

    /** Endpoint to list news */
    @GET("${ALL_NEWS}&${API_KEY}")
    suspend fun getAllNews(): Response<NewsResponse>

    /** Endpoint to item news */
    @GET("{url}${ITEM_FILTER}&${API_KEY}")
    suspend fun getItemNews(@Path("url",encoded = true) url: String): Response<NewsDetailResponse>

}