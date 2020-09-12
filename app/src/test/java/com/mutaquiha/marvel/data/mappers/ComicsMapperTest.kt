package com.mutaquiha.marvel.data.mappers

import com.mutaquiha.data.dto.characters.DTOThumbnail
import com.mutaquiha.data.dto.comics.DTOComic
import com.mutaquiha.data.dto.comics.Price
import com.mutaquiha.data.mapper.ComicsMapper
import com.mutaquiha.marvel.domain.entity.Comic
import com.mutaquiha.marvel.domain.entity.Thumbnail
import org.junit.Test
import junit.framework.Assert.assertEquals

class ComicsMapperTest {

    private val comicsMapper by lazy {
        com.mutaquiha.data.mapper.ComicsMapper()
    }

    @Test
    fun `GIVEN DTOComic WHEN transforming it THEN get proper domain entity Comic`() {
        val comic = comicsMapper.transform(fakeDTOComic)

        assertEquals(comic, expectedFakeComic)
    }

    @Test
    fun `Given DTOComic WHEN transforming it THEN get maximum price of prices available`() {
        val comic = comicsMapper.transform(fakeDTOComic)

        assertEquals(14.5, comic.price)
    }

    @Test
    fun `Given DTOComic with empty list off prices WHEN transforming it THEN get price Zero `() {
        val comic = comicsMapper.transform(fakeDTOComicWithEmptyPrices)

        assertEquals(0.0, comic.price)
    }


    companion object {
        private val fakeDTOComic: com.mutaquiha.data.dto.comics.DTOComic =
            com.mutaquiha.data.dto.comics.DTOComic(
                id = 16890,
                digitalId = 12188,
                title = "Amazing Spider-Man Annual (1964) #16",
                description = "INFESTED ENDS WITH SPIDEY AT THE CROSSROADS! As Spider-Man, he is a member of the FF and TWO different Avengers teams.  As Peter Parker, he works all hours on his dream job at Horizon Labs.  That doesn't leave him with much time for anything or anyone else.  This is where he pays the price. In this landmark issue, one of Peter's greatest sins-- comes back to haunt him. And the life of someone dear to him hangs in the balance. Plus: With New York's Infestation complete, the run-up to Spider-Island is over. Prepare for hell to break loose",
                com.mutaquiha.data.dto.characters.DTOThumbnail(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/b/03/56d72043e5926",
                    extension = "jpg"
                ),
                prices = getPrices(),
            )

        private val expectedFakeComic: Comic = Comic(
            title = "Amazing Spider-Man Annual (1964) #16",
            price = 14.50,
            description = "INFESTED ENDS WITH SPIDEY AT THE CROSSROADS! As Spider-Man, he is a member of the FF and TWO different Avengers teams.  As Peter Parker, he works all hours on his dream job at Horizon Labs.  That doesn't leave him with much time for anything or anyone else.  This is where he pays the price. In this landmark issue, one of Peter's greatest sins-- comes back to haunt him. And the life of someone dear to him hangs in the balance. Plus: With New York's Infestation complete, the run-up to Spider-Island is over. Prepare for hell to break loose",
            Thumbnail(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/b/03/56d72043e5926",
                extension = "jpg"
            ),
        )

        private fun getPrices(): List<com.mutaquiha.data.dto.comics.Price> {
            val listOfPrices = mutableListOf<com.mutaquiha.data.dto.comics.Price>()

            listOfPrices.add(
                com.mutaquiha.data.dto.comics.Price(
                    type = "printPrice",
                    price = 5.8
                ),
            )

            listOfPrices.add(
                com.mutaquiha.data.dto.comics.Price(
                    type = "digitalPurchasePrice",
                    price = 14.50
                )
            )

            return listOfPrices
        }

        private val fakeDTOComicWithEmptyPrices: com.mutaquiha.data.dto.comics.DTOComic =
            com.mutaquiha.data.dto.comics.DTOComic(
                id = 16890,
                digitalId = 12188,
                title = "Amazing Spider-Man Annual (1964) #16",
                description = "INFESTED ENDS WITH SPIDEY AT THE CROSSROADS! As Spider-Man, he is a member of the FF and TWO different Avengers teams.  As Peter Parker, he works all hours on his dream job at Horizon Labs.  That doesn't leave him with much time for anything or anyone else.  This is where he pays the price. In this landmark issue, one of Peter's greatest sins-- comes back to haunt him. And the life of someone dear to him hangs in the balance. Plus: With New York's Infestation complete, the run-up to Spider-Island is over. Prepare for hell to break loose",
                com.mutaquiha.data.dto.characters.DTOThumbnail(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/b/03/56d72043e5926",
                    extension = "jpg"
                ),
                prices = emptyList(),
            )
    }
}