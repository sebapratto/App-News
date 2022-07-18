package com.sebapp.appnews.data.data_store

import kotlinx.coroutines.flow.Flow

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */
interface SettingsDataStore {

    suspend fun toggleDarkMode()

    suspend fun toggleLayout()

    fun readDarkModeValue(): Flow<Boolean>

    fun readLayoutValue(): Flow<Boolean>

}