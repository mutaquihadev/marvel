package com.mutaquiha.marvel.data.mappers

import com.mutaquiha.data.dto.characters.DTOCharacter
import com.mutaquiha.data.mapper.CharactersMapper
import com.mutaquiha.domain.entity.Character
import com.mutaquiha.domain.entity.Thumbnail
import junit.framework.Assert.assertEquals
import org.junit.Test

class CharacterMapperTest {

    private val characterMapper by lazy {
        CharactersMapper()
    }

    @Test
    fun `Given DTOCharacter WHEN transforming it THEN get proper domain entity Character`() {
        val character = characterMapper.transform(fakeDTOCharacter)

        assertEquals(character, expectedFakeCharacter)
    }

    companion object {
        private val fakeDTOCharacter: DTOCharacter =
            DTOCharacter(
                id = 1011334,
                name = "3-D Man",
                description = "",
                DTOThumbnail = com.mutaquiha.data.dto.characters.DTOThumbnail(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                    extension = "jpg"
                ),
                DTOCharacterComics = com.mutaquiha.data.dto.characters.DTOCharacterComics(12, 12)
            )

        private val expectedFakeCharacter = Character(
            id = 1011334,
            name = "3-D Man",
            description = "",
            Thumbnail(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                extension = "jpg"
            ),
            availableComicsCount = 12
        )
    }
}