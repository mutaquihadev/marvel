package com.mutaquiha.domain.entity

data class Comic(
    val title: String,
    val price: Double,
    val description: String?,
    val thumbnail: Thumbnail
)