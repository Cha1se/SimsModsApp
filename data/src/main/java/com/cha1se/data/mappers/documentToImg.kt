package com.cha1se.data.mappers

import android.graphics.Bitmap
import com.cha1se.domain.models.imgListModel
import org.jsoup.nodes.Document

class documentToImg {

    fun result(document: Document): imgListModel {
        var imgList: imgListModel = imgListModel(mutableListOf())
        val elBitmap = document.getElementsByClass("grid-image").select("div[style]")

        (0..elBitmap.size - 1).forEach { i ->
            val style = elBitmap.get(i).attr("style")
            val srcImage = style.split("\'")[1]

            imgList.pictureList.add(urlToBitmap(srcImage).getImage())
        }

        return imgList

    }

}