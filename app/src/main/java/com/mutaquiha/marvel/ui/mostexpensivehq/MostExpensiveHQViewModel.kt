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
import kotlinx.coroutines.delay
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

    val pages = MutableLiveData<String>()

    init {
        character?.let {
            getComics(it)
        }
    }

    private fun getComics(character: Character) {
        val totalPages =
            FindMostExpensiveHQHelper.getNumberOfPages(character.availableComicsCount)

        viewModelScope.launch {
            for (x in 0 until totalPages) {
                val offset = x * PAGE_SIZE

                pages.postValue("$x offset = $offset")

                delay(1000)
            }
        }


//        viewModelScope.launch {
//            val response = repository.getComics(characterId = character.id)
//            _mostExpensiveComic.postValue(response[0])
//        }
    }
}