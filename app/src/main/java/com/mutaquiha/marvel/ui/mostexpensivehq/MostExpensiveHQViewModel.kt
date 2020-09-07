package com.mutaquiha.marvel.ui.mostexpensivehq

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mutaquiha.marvel.commons.Constants
import com.mutaquiha.marvel.data.repositories.ComicsRepository
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.domain.entity.Comic
import kotlinx.coroutines.launch

class MostExpensiveHQViewModel @ViewModelInject constructor(
    private val repository: ComicsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val character: Character? by lazy {
        savedStateHandle.get<Character>(Constants.KEY_CHARACTER)
    }

    init {
        getComics()
    }

    val mostExpensiveComic: LiveData<Comic>
        get() = _mostExpensiveComic
    private val _mostExpensiveComic = MutableLiveData<Comic>()

    private fun getComics() {
        character?.let {
            viewModelScope.launch {
                val response = repository.getComics(characterId = it.id)
                _mostExpensiveComic.postValue(response[0])
            }
        }
    }
}