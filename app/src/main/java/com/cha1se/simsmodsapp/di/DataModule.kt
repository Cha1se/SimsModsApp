package com.cha1se.simsmodsapp.di

import com.cha1se.data.repository.DataRepositoryImpl
import com.cha1se.domain.repository.DataRepository
import org.koin.dsl.module

val dataModule = module {

    single<DataRepository> {
        DataRepositoryImpl()
    }

}
