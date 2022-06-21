package com.sebapp.naranjaxchallenge.domain.model

import com.google.gson.annotations.SerializedName

/**
 *   21,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

data class NewsResponse(
    @SerializedName("response") val response: ResponseNews
)

data class ResponseNews(
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("orderBy") val orderBy: String,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("results") val results: List<Results>,
    @SerializedName("startIndex") val startIndex: Int,
    @SerializedName("status") val status: String,
    @SerializedName("total") val total: Int,
    @SerializedName("userTier") val userTier: String
)

data class Results(
    @SerializedName("apiUrl") val apiUrl: String,
    @SerializedName("fields") val fields: Fields,
    @SerializedName("id") val id: String,
    @SerializedName("isHosted") val isHosted: Boolean,
    @SerializedName("pillarId") val pillarId: String,
    @SerializedName("pillarName") val pillarName: String,
    @SerializedName("sectionId") val sectionId: String,
    @SerializedName("sectionName") val sectionName: String,
    @SerializedName("type") val type: String,
    @SerializedName("webPublicationDate") val webPublicationDate: String,
    @SerializedName("webTitle") val webTitle: String,
    @SerializedName("webUrl") val webUrl: String
)

data class Fields(
    @SerializedName("headline") val headline: String,
    @SerializedName("thumbnail") val thumbnail: String
)