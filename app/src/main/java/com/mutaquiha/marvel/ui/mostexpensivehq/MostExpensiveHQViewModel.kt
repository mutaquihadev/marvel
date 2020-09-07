package com.mutaquiha.marvel.ui.mostexpensivehq

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mutaquiha.marvel.commons.Constants
import com.mutaquiha.marvel.data.dto.comics.ComicResponse
import com.mutaquiha.marvel.data.repositories.ComicsRepository
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.coroutines.launch

class MostExpensiveHQViewModel @ViewModelInject constructor(
    private val repository: ComicsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val character: Character? by lazy {
        savedStateHandle.get<Character>(Constants.KEY_CHARACTER)
    }

    val comics: MutableLiveData<ComicResponse> = MutableLiveData()

    fun getComics() {
        character?.let {
            viewModelScope.launch {
                val response = repository.getComics(characterId = it.id)
                comics.postValue(response)
            }
        }
    }
}