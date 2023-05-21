package com.cha1se.simsmodsapp.di

import com.cha1se.simsmodsapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getDataUseCase = get()
        )
    }

}