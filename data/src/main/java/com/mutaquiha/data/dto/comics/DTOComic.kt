package com.mutaquiha.data.dto.comics

import com.mutaquiha.data.dto.characters.DTOThumbnail

data class DTOComic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val description: String,
    val thumbnail: DTOThumbnail,
    val prices: List<Price>
)