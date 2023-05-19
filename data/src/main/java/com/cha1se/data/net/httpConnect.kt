package com.cha1se.data.net

import com.cha1se.data.mappers.documentToImg
import com.cha1se.data.mappers.documentToTitle
import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.models.titleListModel
import io.reactivex.Single
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class httpConnect {

    fun getImg(url: String): Single<imgListModel> {

        return Single.create {
            val document = Jsoup.connect(url).get()

            var listImgs = documentToImg().result(document)
            it.onSuccess(listImgs)
        }

    }

    fun getTitles(url: String): Single<titleListModel> {

        return Single.create {
            val document = Jsoup.connect(url).get()

            var listTitles = documentToTitle().result(document)
            it.onSuccess(listTitles)
        }

    }
}