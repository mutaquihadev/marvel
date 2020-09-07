package com.mutaquiha.marvel.data.dto.characters

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<DTOCharacter>
)