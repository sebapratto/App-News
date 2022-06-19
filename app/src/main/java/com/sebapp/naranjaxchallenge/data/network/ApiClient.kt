package com.sebapp.naranjaxchallenge.data.network


import com.sebapp.naranjaxchallenge.domain.model.NewsDetailModel
import com.sebapp.naranjaxchallenge.domain.model.NewsSuper
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

    /*@GET("/search?show-fields=all&api-key=${API_KEY}")
    suspend fun getAllNews(): Response<List<News>>*/

    @GET("/marvel")
    suspend fun getAllNews(): Response<List<NewsSuper>>

    @GET("{url}")
    suspend fun getItemNews(@Path("url") url: String): Response<NewsDetailModel>

}