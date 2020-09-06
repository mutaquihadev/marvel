package com.mutaquiha.marvel.data

import com.mutaquiha.marvel.data.dto.CharactersResponse
import retrofit2.http.GET

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(): CharactersResponse
}