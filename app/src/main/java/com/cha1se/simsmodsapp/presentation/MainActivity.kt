package com.cha1se.simsmodsapp.presentation

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cha1se.data.repository.dataRepositoryImpl
import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.models.titleListModel
import com.cha1se.domain.repository.dataRepository
import com.cha1se.domain.usecase.getImgListUseCase
import com.cha1se.domain.usecase.getTitleListUseCase
import com.cha1se.simsmodsapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.security.auth.login.LoginException


class MainActivity : AppCompatActivity() {

    private lateinit var imgView: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var getTitleListUseCase: getTitleListUseCase
    private lateinit var getImgListUseCase: getImgListUseCase
    private lateinit var dataRepository: dataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        dataRepository = dataRepositoryImpl()
        getTitleListUseCase = getTitleListUseCase(dataRepository)
        getImgListUseCase = getImgListUseCase(dataRepository)

        var titles: titleListModel
        var imgs: imgListModel


        getTitleListUseCase.execute()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                titles = it
                getImgListUseCase.execute()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        recyclerView.adapter = CustomRecyclerAdapter(titles, it)
                    }, {Log.e("TAG", it.message.toString())})
            }, { Log.e("TAG", it.message.toString())})


    }

 /*   fun httpConnect() {
        lateinit var bitmap: Bitmap
        var data = mutableListOf<String>()
        var imgBitmap = mutableListOf<Bitmap>()

        Observable.fromCallable {

            val url: String = "https://sims4pack.ru/"
            val document: Document = Jsoup.connect(url).get()
            var elName = document.getElementsByClass("grid-link")
            val elBitmap = document.getElementsByClass("grid-image").select("div[style]")


            (0..elName.size - 1).forEach { i -> data.add(elName.get(i).text().toString()) }

            (0..elBitmap.size - 1).forEach { i ->

                var style = elBitmap.get(i).attr("style")
                var srcImage = style.split("\'")[1]
                Log.e("TAG", srcImage)
                var image = urlToBitmap(srcImage)
                imgBitmap.add(image)

            }

        }.doOnError({ Log.e("ERROR", it.message.toString()) })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {

                recyclerView.adapter = CustomRecyclerAdapter(data, imgBitmap)

            }
            .subscribe()

    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i element") }
        return data
    }

    private fun urlToBitmap(url: String): Bitmap {
        val url = URL(url)
        val image = BitmapFactory.decodeStream(url.openStream())

        return image
    }*/
}

