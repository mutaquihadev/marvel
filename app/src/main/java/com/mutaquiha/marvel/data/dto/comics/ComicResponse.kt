package com.mutaquiha.marvel.data.dto.comics

import com.google.gson.annotations.SerializedName

data class ComicResponse(
    val code: Int,
    @SerializedName("data")
    val comicData: ComicData
)