package com.mutaquiha.data.repositories

import com.mutaquiha.domain.entity.Comic
import com.mutaquiha.data.MarvelApi
import com.mutaquiha.data.dto.comics.asDomainModule
import com.mutaquiha.data.mapper.ComicsMapper

import javax.inject.Inject

class ComicsRepositoryImpl
@Inject
constructor(private val api: MarvelApi, private val mapper: ComicsMapper) : ComicsRepository {
    override suspend fun getComics(characterId: Int, offset: Int): List<Comic> {
        return api.getComics(characterId = characterId, offset = offset).asDomainModule(mapper)
    }
}