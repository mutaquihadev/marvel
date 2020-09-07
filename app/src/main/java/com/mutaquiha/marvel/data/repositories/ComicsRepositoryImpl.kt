package com.mutaquiha.marvel.data.repositories

import com.mutaquiha.marvel.data.MarvelApi
import com.mutaquiha.marvel.data.dto.comics.ComicResponse
import javax.inject.Inject

class ComicsRepositoryImpl
@Inject
constructor(private val api: MarvelApi) : ComicsRepository {
    override suspend fun getComics(characterId: Int): ComicResponse {
        return api.getComics(characterId)
    }
}