package com.mutaquiha.marvel.ui.mostexpensivehq.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mutaquiha.marvel.commons.Constants
import com.mutaquiha.marvel.data.repositories.CharacterRepository
import com.mutaquiha.marvel.domain.entity.Character

class MostExpensiveHQViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val character: Character? by lazy {
        savedStateHandle.get<Character>(Constants.KEY_CHARACTER)
    }
}