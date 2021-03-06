package com.mutaquiha.marvel.data.repositories

import com.mutaquiha.marvel.domain.entity.Comic

interface ComicsRepository {
    suspend fun getComics(characterId: Int, offset: Int = 0): List<Comic>
}