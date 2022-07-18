package com.sebapp.appnews.domain.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

/**
 *   17,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

 /**    data preferences for settings    */

class DataStoreKeys {

    companion object {
        val DARK_MODE_KEY = booleanPreferencesKey("com.sebapp.appnews.DARK_MODE_KEY")
        val LAYOUT_MODE_KEY = booleanPreferencesKey("com.sebapp.appnews.LAYOUT_MODE_KEY")
    }


}