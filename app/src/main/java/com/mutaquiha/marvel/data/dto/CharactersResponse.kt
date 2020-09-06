package com.mutaquiha.marvel.data.dto

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val data: Data
)