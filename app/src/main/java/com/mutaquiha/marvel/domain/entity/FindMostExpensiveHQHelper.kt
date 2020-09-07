package com.mutaquiha.marvel.domain.entity

const val MAX_ALLOWED_OFFSET = 100

class FindMostExpensiveHQHelper {


    companion object  {
        fun getNumberOfPages(availableComicsCount: Int): Int {
            val reminder = availableComicsCount % MAX_ALLOWED_OFFSET
            val pages =   availableComicsCount / MAX_ALLOWED_OFFSET
            val additionalPage = if (reminder > 0) {
                1
            } else {
                0
            }

            return pages + additionalPage
        }
    }
}