package com.cha1se.domain.usecase

import com.cha1se.domain.models.DataModel
import com.cha1se.domain.repository.DataRepository
import io.reactivex.Single

class GetDataUseCase(val dataRepository: DataRepository) {

    fun execute(): Single<DataModel> {
        return dataRepository.getData()
    }

}