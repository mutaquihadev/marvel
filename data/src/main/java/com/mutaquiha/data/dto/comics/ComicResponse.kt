package com.mutaquiha.data.dto.comics

import com.google.gson.annotations.SerializedName
import com.mutaquiha.data.mapper.ComicsMapper
import com.mutaquiha.domain.entity.Comic

data class ComicResponse(
    val code: Int,
    @SerializedName("data")
    val comicData: ComicData
)

fun ComicResponse.asDomainModule(mapper: ComicsMapper): List<Comic> {
    return comicData.results.map(mapper::transform)
}