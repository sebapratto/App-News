package com.sebapp.naranjaxchallenge.domain.model

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */
data class NewsDetailModel(
    val status: String, // "ok"
    val results: List<NewsDetailResult>
)

data class NewsDetailResult(
    val id: String, // "politics/blog/2014/feb/17/alex-salmond-speech-first-minister-scottish-independence-eu-currency-live",
    val sectionId: String, //"politics",
    val sectionName: String, // "Politics",
    val webPublicationDate: String, // "2014-02-17T12:05:47Z",
    val webTitle: String, // "Alex Salmond speech – first minister hits back over Scottish independence – live",
    val webUrl: String, // "https://www.theguardian.com/politics/blog/2014/feb/17/alex-salmond-speech-first-minister-scottish-independence-eu-currency-live",
    val apiUrl: String // "https://content.guardianapis.com/politics/blog/2014/feb/17/alex-salmond-speech-first-minister-scottish-independence-eu-currency-live"
)
