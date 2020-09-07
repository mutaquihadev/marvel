package com.mutaquiha.marvel.data.dto.characters

import com.google.gson.annotations.SerializedName
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.domain.entity.Thumbnail

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val characterData: CharacterData
)

fun CharactersResponse.asDomainModel(): List<Character> {
    return characterData.results.map {
        Character(
            it.id,
            it.name,
            it.description,
            Thumbnail(it.DTOThumbnail.path, it.DTOThumbnail.extension),
            it.DTOCharacterComics.available
        )
    }
}