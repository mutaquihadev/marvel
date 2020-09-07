package com.mutaquiha.marvel.data.mapper

import com.mutaquiha.marvel.data.dto.comics.DTOComic
import com.mutaquiha.marvel.domain.entity.Comic
import com.mutaquiha.marvel.domain.entity.Thumbnail

class ComicsMapper : BaseMapper<DTOComic, Comic>() {
    override fun transform(entity: DTOComic): Comic {

        var greaterPrice = 0.0
        entity.prices.forEach {
            if (it.price > greaterPrice) {
                greaterPrice = it.price
            }
        }

        return Comic(
            entity.title,
            greaterPrice,
            entity.description,
            Thumbnail(entity.thumbnail.path, entity.thumbnail.extension))
    }
}