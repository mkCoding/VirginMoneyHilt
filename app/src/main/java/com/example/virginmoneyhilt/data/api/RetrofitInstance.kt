package com.example.virginmoneyhilt.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitInstance{
        private val loggingInterceptor = HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val converter = GsonConverterFactory.create()
        private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(ApiDetail.BASE_URL_PEOPLE)
            .client(okHttpClient)
            .addConverterFactory(converter).build()

        val apiClient = retrofit.create(ApiEndpoints::class.java)

    }

