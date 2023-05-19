package com.cha1se.data.mappers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

class UrlToBitmap(private val url: String) {

    fun getImage(): Bitmap {
        val url = URL(url)
        val image = BitmapFactory.decodeStream(url.openStream())
        return image
    }

}