package com.example.kingpin.network

import com.example.kingpin.utils.BASE_URL
import com.example.kingpin.utils.BASE_URL2
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private val okHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .build()

    fun createApiService(): APIservice {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(APIservice::class.java)
    }

    fun createSubmitService(): APIservice{

        val retrofit2 = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL2)
            .build()

        return retrofit2.create(APIservice::class.java)
    }
}