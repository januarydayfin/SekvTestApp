package com.krayapp.sekvtestapp.model.remoteAccess

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadInto(url:String, container:ImageView){
        Picasso
            .get()
            .load(url)
            .into(container)
    }
}