package com.mutaquiha.data.repositories

import androidx.paging.PagingData
import com.mutaquiha.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<Character>>
}