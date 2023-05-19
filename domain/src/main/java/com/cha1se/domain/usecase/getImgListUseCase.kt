package com.cha1se.domain.usecase

import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.repository.dataRepository
import io.reactivex.Single

class getImgListUseCase(private val dataRepository: dataRepository) {

    fun execute(): Single<imgListModel> {
        return dataRepository.getImages()
    }

}