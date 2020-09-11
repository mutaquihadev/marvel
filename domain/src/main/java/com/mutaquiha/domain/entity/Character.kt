package com.mutaquiha.domain.entity

import com.mutaquiha.domain.entity.Thumbnail
import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val Thumbnail: Thumbnail,
    val availableComicsCount: Int
) : Serializable