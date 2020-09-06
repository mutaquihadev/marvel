package com.mutaquiha.marvel.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mutaquiha.marvel.data.repositories.CharacterRepository
import com.mutaquiha.marvel.domain.NetworkViewState
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharactersListViewModel
@ViewModelInject
constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val viewState: MutableLiveData<NetworkViewState<List<Character>>> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch {
            repository
                .getCharacters()
                .catch { viewState.postValue(NetworkViewState.Error("Error on get characters")) }
                .collect { result -> viewState.postValue(NetworkViewState.Success(result)) }
        }
    }
}