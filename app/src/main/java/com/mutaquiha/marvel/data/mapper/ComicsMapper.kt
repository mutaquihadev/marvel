package com.mutaquiha.marvel.data.mapper

import com.mutaquiha.marvel.data.dto.comics.DTOComic
import com.mutaquiha.marvel.domain.entity.Comic
import com.mutaquiha.marvel.domain.entity.Thumbnail

class ComicsMapper : BaseMapper<DTOComic, Comic>() {
    override fun transform(entity: DTOComic): Comic {

        val price = entity.prices.map { it.price }.maxOrNull()

        return Comic(
            entity.title,
            price ?: 0.0,
            entity.description,
            Thumbnail(entity.thumbnail.path, entity.thumbnail.extension)
        )
    }
}