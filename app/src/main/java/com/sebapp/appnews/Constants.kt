package com.sebapp.appnews

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

    /**   URL for endpoints     */

object Constants {

    const val BASE_URL = "https://content.guardianapis.com/"
    const val ALL_NEWS = "search?q=%20&years&a&slave&format=json&tag=film/film,tone/reviews&page_size=1&from-date=2022-06-01&show-fields=headline,thumbnail&order-by=relevance"
    const val API_KEY = "api-key=9a92eea5-63d0-4633-9e3c-99df6d3c8a59"
    const val ITEM_FILTER = "?show-fields=bodyText,thumbnail"

}