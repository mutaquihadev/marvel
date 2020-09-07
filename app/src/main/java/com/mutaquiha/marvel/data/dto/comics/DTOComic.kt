package com.mutaquiha.marvel.data.dto.comics

data class DTOComic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val prices: List<Price>
)