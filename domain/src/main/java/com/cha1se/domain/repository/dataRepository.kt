package com.cha1se.domain.repository

import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.models.titleListModel
import io.reactivex.Single

interface dataRepository {

    fun getImages() : Single<imgListModel>

    fun getTitles() : Single<titleListModel>

}