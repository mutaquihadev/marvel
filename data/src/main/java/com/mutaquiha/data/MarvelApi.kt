package com.mutaquiha.data

import com.mutaquiha.data.dto.characters.CharactersResponse
import com.mutaquiha.data.dto.comics.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(@Query("offset") offset: Int? = 0): CharactersResponse

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path("characterId") characterId: Int,
        @Query("offset") offset: Int? = 0
    ): ComicResponse
}