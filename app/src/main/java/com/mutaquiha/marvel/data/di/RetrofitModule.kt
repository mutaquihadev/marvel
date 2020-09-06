package com.mutaquiha.marvel.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mutaquiha.marvel.commons.Constants.API_KEY
import com.mutaquiha.marvel.commons.Constants.BASE_URL
import com.mutaquiha.marvel.commons.Constants.PARAMETER_API_KEY
import com.mutaquiha.marvel.commons.Constants.PARAMETER_HASH
import com.mutaquiha.marvel.commons.Constants.PARAMETER_TIMESTAMP
import com.mutaquiha.marvel.commons.Constants.PRIVATE_KEY
import com.mutaquiha.marvel.commons.Constants.TIMEZONE
import com.mutaquiha.marvel.commons.extensions.md5
import com.mutaquiha.marvel.data.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val timeStamp =
                (Calendar.getInstance(TimeZone.getTimeZone(TIMEZONE)).timeInMillis / 1000L).toString()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(PARAMETER_API_KEY, API_KEY)
                .addQueryParameter(PARAMETER_TIMESTAMP, timeStamp)
                .addQueryParameter(PARAMETER_HASH, "$timeStamp$PRIVATE_KEY$API_KEY".md5())
                .build()

            chain.proceed(original.newBuilder().url(url).build())
        }

        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideApi(gson: Gson, client: OkHttpClient): MarvelApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        return retrofit.create(MarvelApi::class.java)
    }
}
