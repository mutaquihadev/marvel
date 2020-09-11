package com.mutaquiha.marvel.ui.characterlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mutaquiha.marvel.data.repositories.CharacterRepository

import kotlinx.coroutines.flow.Flow

class CharactersListViewModel
@ViewModelInject
constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun getCharacters(): Flow<PagingData<com.mutaquiha.domain.entity.Character>> {
        return repository.getCharacters().cachedIn(viewModelScope)
    }
}