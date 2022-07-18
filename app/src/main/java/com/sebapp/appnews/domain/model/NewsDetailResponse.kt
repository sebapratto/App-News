package com.sebapp.appnews.domain.model


import com.google.gson.annotations.SerializedName

/**
 *   21,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

data class NewsDetailResponse(
    @SerializedName("response") val response: ResponseItem
)

data class ResponseItem(
    @SerializedName("content") val content: ContentItem,
    @SerializedName("status") val status: String,
    @SerializedName("total") val total: Int,
    @SerializedName("userTier") val userTier: String
)

data class ContentItem(
    @SerializedName("apiUrl") val apiUrl: String,
    @SerializedName("fields") val fields: FieldsItem,
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

data class FieldsItem(
    @SerializedName("bodyText") val bodyText: String,
    @SerializedName("thumbnail") val thumbnail: String
)