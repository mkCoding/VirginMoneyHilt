package com.example.virginmoneyhilt.di

import com.example.virginmoneyhilt.data.api.ApiDetail
import com.example.virginmoneyhilt.data.api.ApiEndpoints
import com.example.virginmoneyhilt.data.api.RetrofitInstance
import com.example.virginmoneyhilt.data.repository.Repository
import com.example.virginmoneyhilt.data.repository.RepositoryImplementation
import com.google.gson.Gson
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun providesGson():Gson{
        return Gson()
    }

    @Provides
    fun providesLoggingInterseptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun showingADummyNameSample(gson:Gson) = GsonConverterFactory.create()

    @Provides
    fun providesOkHttpClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(ApiDetail.BASE_URL_PEOPLE)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()


    @Provides
    fun apiInstance(retrofit: Retrofit): ApiEndpoints = retrofit.create(ApiEndpoints::class.java)

    @Provides
    fun providesRepository(apiEndpoints: ApiEndpoints): Repository {
        return RepositoryImplementation(apiEndpoints)
    }

}