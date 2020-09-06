package com.mutaquiha.marvel.data.dto

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<DTOCharacter>
)