package com.sebapp.naranjaxchallenge.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sebapp.naranjaxchallenge.Constants
import com.sebapp.naranjaxchallenge.data.network.ApiClient
import com.sebapp.naranjaxchallenge.extra_utils_test.MainCoroutineRule
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 21,junio,2022
 *
 * Created by
 * Sebastian Pratto (Misiones, Arg.)
 */

@RunWith(AndroidJUnit4::class)
@Config(manifest=Config.NONE)
class MainActivityTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var mainActivity: MainActivity
    private lateinit var services: ApiClient

    private val url_trunk = "https://content.guardianapis.com/film/2022/jun/05/bergman-island-reiew-mia-hansen-love-vicky-kriep-tim-roth-mia-wasikowska?"
    private val url_item = "https://content.guardianapis.com/film/2022/jun/05/bergman-island-review-mia-hansen-love-vicky-krieps-tim-roth-mia-wasikowska"

    companion object{
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon(){
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Before
    fun setup(){
        mainActivity = MainActivity()
        services = retrofit.create(ApiClient::class.java)

    }

    @Test
    fun `check service news return not null`(){
        runBlocking {
            val result = services.getAllNews()
            assertThat("Service return null value", result, `is`(notNullValue())
            )
        }
    }

    @Test
    fun `check service news return code 200`(){
        runBlocking {
            val result = services.getAllNews()
            assertThat("Service return other code result", result.code(), `is`(200)
            )
        }
    }

    @Test
    fun `check service item news return 404`(){
        runBlocking {
            val result = services.getItemNews("$url_trunk")
            assertThat("Service return other code result", result.code(), `is`(404)
            )
        }
    }

    @Test
    fun `check service item news return 200`(){
        runBlocking {
            val result = services.getItemNews("$url_item")
            assertThat("Service return other code result", result.code(), `is`(200)
            )
        }
    }

}