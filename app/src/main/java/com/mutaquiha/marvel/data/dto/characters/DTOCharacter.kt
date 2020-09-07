package com.mutaquiha.marvel.data.dto.characters

import com.google.gson.annotations.SerializedName

data class DTOCharacter(
    val id: Int,
    val name: String, val description: String,
    @SerializedName("thumbnail")
    val DTOThumbnail: DTOThumbnail,
    @SerializedName("comics")
    val DTOCharacterComics: DTOCharacterComics
)