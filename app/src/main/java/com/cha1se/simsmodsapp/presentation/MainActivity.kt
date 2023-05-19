package com.cha1se.simsmodsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cha1se.data.repository.DataRepositoryImpl
import com.cha1se.domain.repository.DataRepository
import com.cha1se.domain.usecase.GetDataUseCase
import com.cha1se.simsmodsapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var getDataUseCase: GetDataUseCase
    private lateinit var dataRepository: DataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        dataRepository = DataRepositoryImpl()
        getDataUseCase = GetDataUseCase(dataRepository)

        viewMods()

    }

    fun viewMods() {
        var dispose = getDataUseCase.execute()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                recyclerView.adapter = CustomRecyclerAdapter(
                    names = it.listTitles,
                    img = it.listImgs
                )
            }, {})
    }

}

