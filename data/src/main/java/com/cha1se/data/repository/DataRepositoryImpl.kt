package com.cha1se.data.repository

import com.cha1se.data.net.ConnectToServer
import com.cha1se.domain.models.DataModel
import com.cha1se.domain.repository.DataRepository
import io.reactivex.Single

class DataRepositoryImpl : DataRepository {

    val URL = "https://sims4pack.ru/"

    override fun getData(): Single<DataModel> {
        return ConnectToServer().getData(URL)
    }

}