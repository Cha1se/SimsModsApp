package com.cha1se.data.mappers

import com.cha1se.domain.models.titleListModel
import org.jsoup.nodes.Document

class documentToTitle {

    fun result(document: Document): titleListModel {
        var titleList: titleListModel = titleListModel(mutableListOf())

        val elName = document.getElementsByClass("grid-link")

        (0..elName.size - 1).forEach { i ->
            titleList.titlesList.add(
                elName.get(i).text().toString()
            )
        }
        return titleList
    }

}