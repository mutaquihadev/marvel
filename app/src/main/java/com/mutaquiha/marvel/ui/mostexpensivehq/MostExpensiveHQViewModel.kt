package com.mutaquiha.marvel.ui.mostexpensivehq

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mutaquiha.marvel.commons.Constants
import com.mutaquiha.marvel.commons.Constants.PAGE_SIZE
import com.mutaquiha.marvel.data.repositories.ComicsRepository
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.domain.entity.Comic
import com.mutaquiha.marvel.domain.entity.FindMostExpensiveHQHelper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MostExpensiveHQViewModel @ViewModelInject constructor(
    private val repository: ComicsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val character: Character? by lazy {
        savedStateHandle.get<Character>(Constants.KEY_CHARACTER)
    }

    val mostExpensiveComic: LiveData<Comic>
        get() = _mostExpensiveComic
    private val _mostExpensiveComic = MutableLiveData<Comic>()

    init {
        character?.let {
            getComics(it)
        }
    }

    private fun getComics(character: Character) {
        val totalPages =
            FindMostExpensiveHQHelper.getNumberOfPages(character.availableComicsCount)
        val id = character.id
        val listOfDeferred = mutableListOf<Deferred<List<Comic>>>()

        viewModelScope.launch {
            for (x in 0 until totalPages) {
                val offset = x * PAGE_SIZE
                val deferredComics = async { repository.getComics(id, offset) }
                listOfDeferred.add(deferredComics)
            }

            val comics = listOfDeferred.flatMap { it.await() }
            val theMostExpensiveComic = FindMostExpensiveHQHelper.getTheMostExpensiveComic(comics)
            _mostExpensiveComic.postValue(theMostExpensiveComic)
        }
    }
}