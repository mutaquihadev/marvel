package com.mutaquiha.marvel.domain.entity

import com.mutaquiha.marvel.commons.Constants

class FindMostExpensiveHQHelper {

    companion object  {
        fun getNumberOfPages(availableComicsCount: Int): Int {
            val reminder = availableComicsCount % Constants.PAGE_SIZE
            val pages =   availableComicsCount / Constants.PAGE_SIZE
            val additionalPage = if (reminder > 0) {
                1
            } else {
                0
            }

            return pages + additionalPage
        }
    }
}