package com.mutaquiha.marvel.data

import com.mutaquiha.marvel.data.dto.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(@Query("offset") offset: Int? = 0): CharactersResponse
}