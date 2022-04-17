package com.krayapp.sekvtestapp.model.remoteAccess

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadPreview(url:String, container:ImageView){
        Picasso
            .get()
            .load(url)
            .resize(400,400)
            .into(container)
    }
    fun loadPoster(url:String, container:ImageView){
        Picasso
            .get()
            .load(url)
            .into(container)
    }
}