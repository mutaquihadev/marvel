package com.mutaquiha.marvel.commons.extensions

import com.mutaquiha.marvel.commons.ImageSize
import com.mutaquiha.marvel.domain.entity.Character


fun Character.getImageUrl(sizeOfImage: String = ImageSize.STANDARD_MEDIUM): String {
    return "${this.Thumbnail.path}/$sizeOfImage.${this.Thumbnail.extension}"
}