package com.cha1se.data.net

import com.cha1se.data.mappers.DocumentToImg
import com.cha1se.data.mappers.DocumentToTitle
import com.cha1se.domain.models.DataModel
import io.reactivex.Single
import org.jsoup.Jsoup

class ConnectToServer {

    fun getData(url: String): Single<DataModel> {
        return Single.create {
            val document = Jsoup.connect(url).get()

            var listTitles = DocumentToTitle().result(document)
            var listImgs = DocumentToImg().result(document)

            it.onSuccess(DataModel(listImgs, listTitles))
        }
    }
}