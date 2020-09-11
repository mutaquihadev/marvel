package com.mutaquiha.domain.entity

import android.nfc.tech.MifareUltralight.PAGE_SIZE

class FindMostExpensiveHQHelper {

    companion object {
        fun getNumberOfPages(availableComicsCount: Int): Int {
            val reminder = availableComicsCount % PAGE_SIZE
            val pages = availableComicsCount / PAGE_SIZE
            val additionalPage = if (reminder > 0) {
                1
            } else {
                0
            }

            return pages + additionalPage
        }

        fun getTheMostExpensiveComic(comicsList: List<Comic>): Comic {
            var mostExpensiveComic = comicsList[0]
            for (comic in comicsList) {
                if (comic.price > mostExpensiveComic.price) {
                    mostExpensiveComic = comic
                }
            }

            return mostExpensiveComic
        }
    }
}