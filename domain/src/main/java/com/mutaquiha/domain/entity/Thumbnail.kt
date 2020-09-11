package com.mutaquiha.domain.entity

import java.io.Serializable

data class Thumbnail(
    val path: String,
    val extension: String
) : Serializable