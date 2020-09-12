package com.mutaquiha.data.mapper

import com.mutaquiha.domain.entity.Comic
import com.mutaquiha.domain.entity.Thumbnail
import com.mutaquiha.data.dto.comics.DTOComic


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