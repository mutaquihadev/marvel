package com.mutaquiha.marvel.data.repositories

import com.mutaquiha.marvel.data.MarvelApi
import com.mutaquiha.marvel.data.mapper.CharacterMapper
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl
@Inject
constructor(
    private val marvelApi: MarvelApi,
    private val mapper: CharacterMapper
) : CharacterRepository {
    override fun getCharacters(): Flow<List<Character>> = flow {
        emit(mapper.transform(marvelApi.getCharacters()))
    }
}