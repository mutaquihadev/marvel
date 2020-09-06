package com.mutaquiha.marvel.data

import com.google.gson.GsonBuilder
import com.mutaquiha.marvel.commons.Constants.API_KEY
import com.mutaquiha.marvel.commons.Constants.BASE_URL
import com.mutaquiha.marvel.commons.Constants.PARAMETER_API_KEY
import com.mutaquiha.marvel.commons.Constants.PARAMETER_HASH
import com.mutaquiha.marvel.commons.Constants.PARAMETER_TIMESTAMP
import com.mutaquiha.marvel.commons.Constants.PRIVATE_KEY
import com.mutaquiha.marvel.commons.Constants.TIMEZONE
import com.mutaquiha.marvel.commons.extensions.md5
import com.mutaquiha.marvel.data.dto.CharactersResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(): CharactersResponse

    companion object {
        fun getService(): MarvelApi {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url

                val timestamp =
                    (Calendar.getInstance(TimeZone.getTimeZone(TIMEZONE)).timeInMillis / 1000L).toString()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter(PARAMETER_API_KEY, API_KEY)
                    .addQueryParameter(PARAMETER_TIMESTAMP, timestamp)
                    .addQueryParameter(PARAMETER_HASH, "$timestamp$PRIVATE_KEY$API_KEY".md5())
                    .build()

                chain.proceed(original.newBuilder().url(url).build())
            }

            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

            return retrofit.create(MarvelApi::class.java)
        }
    }
}