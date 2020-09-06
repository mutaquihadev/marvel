package com.mutaquiha.marvel.data.mapper

import com.mutaquiha.marvel.commons.BaseMapper
import com.mutaquiha.marvel.data.dto.CharactersResponse
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.domain.entity.Thumbnail

class CharacterMapper : BaseMapper<CharactersResponse, List<Character>>() {

    override fun transform(entity: CharactersResponse): List<Character> {
        return entity.let { charactersResponse ->
            val characterList = charactersResponse.data.results.map { dtoCharacter ->
                Character(
                    dtoCharacter.id,
                    dtoCharacter.name,
                    dtoCharacter.description,
                    Thumbnail(dtoCharacter.DTOThumbnail.path, dtoCharacter.DTOThumbnail.extension)
                )
            }

            characterList
        }
    }
}
