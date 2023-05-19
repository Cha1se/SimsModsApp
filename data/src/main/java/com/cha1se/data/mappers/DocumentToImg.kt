package com.cha1se.data.mappers

import android.graphics.Bitmap
import org.jsoup.nodes.Document

class DocumentToImg {

    fun result(document: Document): MutableList<Bitmap> {
        var imgList = mutableListOf<Bitmap>()
        val elBitmap = document.getElementsByClass("grid-image").select("div[style]")

        (0..elBitmap.size - 1).forEach { i ->
            val style = elBitmap.get(i).attr("style")
            val srcImage = style.split("\'")[1]

            imgList.add(UrlToBitmap(srcImage).getImage())
        }

        return imgList

    }

}