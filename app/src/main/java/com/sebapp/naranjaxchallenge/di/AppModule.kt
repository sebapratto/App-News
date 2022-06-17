package com.sebapp.naranjaxchallenge.di

import android.app.Application
import android.provider.SyncStateContract
import com.sebapp.naranjaxchallenge.Constants
import com.sebapp.naranjaxchallenge.Constants.BASE_URL
import com.sebapp.naranjaxchallenge.data.network.ApiClient
import com.sebapp.naranjaxchallenge.domain.repositories.NewsRepository
import com.sebapp.naranjaxchallenge.domain.repositories.SettingsRepository
import com.sebapp.naranjaxchallenge.presentation.news_list.NewsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Retrofit */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /** ApiClient */
    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsListAdapter() = NewsListAdapter()

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsList: ApiClient
    ) = NewsRepository(newsList)

    @Provides
    @Singleton
    fun provideSettingsRepository(
        application: Application
    ): SettingsRepository {
        return SettingsRepository(application)
    }


}