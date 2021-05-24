package com.example.kavakexam.presentation.utils

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {

    fun getInstance(): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}