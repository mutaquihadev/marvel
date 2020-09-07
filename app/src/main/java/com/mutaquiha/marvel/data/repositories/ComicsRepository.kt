package com.mutaquiha.marvel.data.repositories

import com.mutaquiha.marvel.data.dto.comics.ComicResponse

interface ComicsRepository {
    suspend fun getComics(characterId: Int): ComicResponse
}