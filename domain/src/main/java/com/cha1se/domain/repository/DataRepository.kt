package com.cha1se.domain.repository

import com.cha1se.domain.models.DataModel
import io.reactivex.Single

interface DataRepository {

    fun getData(): Single<DataModel>

}