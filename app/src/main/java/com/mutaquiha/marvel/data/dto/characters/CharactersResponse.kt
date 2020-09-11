package com.mutaquiha.marvel.data.dto.characters

import com.google.gson.annotations.SerializedName
import com.mutaquiha.domain.entity.Character
import com.mutaquiha.marvel.data.mapper.CharactersMapper

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val characterData: CharacterData
)

fun CharactersResponse.asDomainModel(mapper: CharactersMapper): List<Character> {
    return characterData.results.map(mapper::transform)
}