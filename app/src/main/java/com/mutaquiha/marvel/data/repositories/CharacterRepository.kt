package com.mutaquiha.marvel.data.repositories

import androidx.paging.PagingData
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<Character>>
}