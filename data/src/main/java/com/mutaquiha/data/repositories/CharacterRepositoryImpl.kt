package com.mutaquiha.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mutaquiha.domain.entity.Character
import com.mutaquiha.data.MarvelApi
import com.mutaquiha.data.mapper.CharactersMapper
import com.mutaquiha.data.paging.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl
@Inject
constructor(
    private val marvelApi: MarvelApi,
    private val mapper: CharactersMapper
) : CharacterRepository {
    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharactersPagingSource(marvelApi, mapper) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}