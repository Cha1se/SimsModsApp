package com.cha1se.data.repository

import com.cha1se.data.net.httpConnect
import com.cha1se.data.mappers.documentToImg
import com.cha1se.data.mappers.documentToTitle
import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.models.titleListModel
import com.cha1se.domain.repository.dataRepository
import io.reactivex.Single
import org.jsoup.nodes.Document

class dataRepositoryImpl : dataRepository {

    val URL = "https://sims4pack.ru/"

    override fun getImages(): Single<imgListModel> {

        return httpConnect().getImg(URL)

    }

    override fun getTitles(): Single<titleListModel> {

        return httpConnect().getTitles(URL)

    }


}