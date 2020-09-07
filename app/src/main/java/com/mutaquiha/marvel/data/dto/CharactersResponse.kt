package com.mutaquiha.marvel.data.dto

import com.google.gson.annotations.SerializedName
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.domain.entity.Thumbnail

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val data: Data
)

fun CharactersResponse.asDomainModel(): List<Character> {
    return data.results.map {
        Character(
            it.id,
            it.name,
            it.description,
            Thumbnail(it.DTOThumbnail.path, it.DTOThumbnail.extension),
            it.DTOComics.available
        )
    }
}