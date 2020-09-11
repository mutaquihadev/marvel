package com.mutaquiha.marvel.data.mapper

import com.mutaquiha.domain.entity.Character
import com.mutaquiha.domain.entity.Thumbnail
import com.mutaquiha.marvel.data.dto.characters.DTOCharacter

class CharactersMapper : BaseMapper<DTOCharacter, Character>() {
    override fun transform(entity: DTOCharacter): Character {
        return Character(
            entity.id,
            entity.name,
            entity.description,
            Thumbnail(entity.DTOThumbnail.path, entity.DTOThumbnail.extension),
            entity.DTOCharacterComics.available
        )
    }
}