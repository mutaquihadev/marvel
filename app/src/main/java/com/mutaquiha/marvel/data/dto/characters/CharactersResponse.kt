package com.mutaquiha.marvel.data.dto.characters

import com.google.gson.annotations.SerializedName
import com.mutaquiha.marvel.data.mapper.CharactersMapper
import com.mutaquiha.marvel.domain.entity.Character

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val characterData: CharacterData
)

fun CharactersResponse.asDomainModel(mapper: CharactersMapper): List<Character> {
    return characterData.results.map(mapper::transform)
}