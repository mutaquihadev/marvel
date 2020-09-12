package com.mutaquiha.domain.extensions

import com.mutaquiha.domain.entity.Character
import com.mutaquiha.domain.entity.Comic
import com.mutaquiha.marvel.app.core.ImageSize

fun Character.getImageUrl(sizeOfImage: String = ImageSize.STANDARD_MEDIUM): String {
    return "${this.Thumbnail.path}/$sizeOfImage.${this.Thumbnail.extension}"
}

fun Comic.getImageUrl(sizeOfImage: String): String {
    return "${this.thumbnail.path}/$sizeOfImage.${this.thumbnail.extension}"
}