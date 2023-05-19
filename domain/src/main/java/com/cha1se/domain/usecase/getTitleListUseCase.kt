package com.cha1se.domain.usecase

import com.cha1se.domain.models.titleListModel
import com.cha1se.domain.repository.dataRepository
import io.reactivex.Single

class getTitleListUseCase(private val dataRepository: dataRepository) {

    fun execute(): Single<titleListModel> {
        return dataRepository.getTitles()
    }

}