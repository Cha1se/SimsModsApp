package com.cha1se.simsmodsapp.di

import com.cha1se.domain.usecase.GetDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetDataUseCase> {
        GetDataUseCase(dataRepository = get())
    }

}
