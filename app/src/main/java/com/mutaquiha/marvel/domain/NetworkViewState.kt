package com.mutaquiha.marvel.domain

sealed class NetworkViewState<T> {
    class Loading<T> : NetworkViewState<T>()
    class Success<T>(val result: T) : NetworkViewState<T>()
    class Error<T>(val error: String) : NetworkViewState<T>()
}