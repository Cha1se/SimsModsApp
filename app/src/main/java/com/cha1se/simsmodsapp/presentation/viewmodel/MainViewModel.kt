package com.cha1se.simsmodsapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.cha1se.domain.usecase.GetDataUseCase
import com.cha1se.simsmodsapp.presentation.CustomRecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    fun viewMods(recyclerView: RecyclerView) {

        var dispose = getDataUseCase.execute()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                recyclerView.adapter = CustomRecyclerAdapter(
                    names = it.listTitles,
                    img = it.listImgs
                )
            }, { Log.e("VM", it.message.toString())})
    }

}