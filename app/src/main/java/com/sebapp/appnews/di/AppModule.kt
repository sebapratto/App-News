package com.sebapp.appnews.di

import android.app.Application
import com.sebapp.appnews.Constants.BASE_URL
import com.sebapp.appnews.data.network.ApiClient
import com.sebapp.appnews.domain.repositories.NewsRepository
import com.sebapp.appnews.domain.repositories.SettingsRepository
import com.sebapp.appnews.presentation.news_list.NewsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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
        apiClient: ApiClient
    ) = NewsRepository(apiClient)

    @Provides
    @Singleton
    fun provideSettingsRepository(
        application: Application
    ): SettingsRepository {
        return SettingsRepository(application)
    }


}