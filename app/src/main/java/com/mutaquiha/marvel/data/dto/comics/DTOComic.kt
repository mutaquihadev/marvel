package com.mutaquiha.marvel.data.dto.comics

import com.mutaquiha.marvel.data.dto.characters.DTOThumbnail

data class DTOComic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val thumbnail: DTOThumbnail,
    val prices: List<Price>
)