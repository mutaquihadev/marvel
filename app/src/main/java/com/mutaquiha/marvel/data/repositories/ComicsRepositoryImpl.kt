package com.mutaquiha.marvel.data.repositories

import com.mutaquiha.marvel.data.MarvelApi
import com.mutaquiha.marvel.data.dto.comics.asDomainModule
import com.mutaquiha.marvel.data.mapper.ComicsMapper
import com.mutaquiha.marvel.domain.entity.Comic
import javax.inject.Inject

class ComicsRepositoryImpl
@Inject
constructor(private val api: MarvelApi, private val mapper: ComicsMapper) : ComicsRepository {
    override suspend fun getComics(characterId: Int): List<Comic> {
        return api.getComics(characterId).asDomainModule(mapper)
    }
}