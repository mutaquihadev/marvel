package com.mutaquiha.marvel.data.dto.comics

import com.google.gson.annotations.SerializedName
import com.mutaquiha.marvel.data.mapper.ComicsMapper
import com.mutaquiha.marvel.domain.entity.Comic

data class ComicResponse(
    val code: Int,
    @SerializedName("data")
    val comicData: ComicData
)

fun ComicResponse.asDomainModule(mapper: ComicsMapper): List<Comic> {
    return comicData.results.map(mapper::transform)
}