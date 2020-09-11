package com.mutaquiha.marvel.data.paging

import androidx.paging.PagingSource
import com.mutaquiha.marvel.data.MarvelApi
import com.mutaquiha.marvel.data.dto.characters.asDomainModel
import com.mutaquiha.marvel.data.mapper.CharactersMapper
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.mutaquiha.domain.entity.Character

private const val MARVEL_API_STARTING_PAGE_INDEX = 0

class CharactersPagingSource
@Inject
constructor(private val api: MarvelApi, private val mapper: CharactersMapper) :
    PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: MARVEL_API_STARTING_PAGE_INDEX
        val offset = position * NETWORK_PAGE_SIZE

        return try {
            val characters = api.getCharacters(offset).asDomainModel(mapper)
            LoadResult.Page(
                data = characters,
                prevKey = if (position == MARVEL_API_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (characters.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}
