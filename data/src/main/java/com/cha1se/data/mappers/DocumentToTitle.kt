package com.cha1se.data.mappers

import org.jsoup.nodes.Document

class DocumentToTitle {

    fun result(document: Document): MutableList<String> {
        var titleList= mutableListOf<String>()

        val elName = document.getElementsByClass("grid-link")

        (0..elName.size - 1).forEach { i ->
            titleList.add(
                elName.get(i).text().toString()
            )
        }
        return titleList
    }

}