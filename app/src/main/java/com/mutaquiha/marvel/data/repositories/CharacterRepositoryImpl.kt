package com.mutaquiha.marvel.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mutaquiha.marvel.data.MarvelApi
import com.mutaquiha.marvel.data.paging.CharactersPagingSource
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl
@Inject
constructor(
    private val marvelApi: MarvelApi
) : CharacterRepository {
    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharactersPagingSource(marvelApi) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}