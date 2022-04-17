package com.krayapp.sekvtestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.model.remoteAccess.FilmDTO
import com.krayapp.sekvtestapp.view.adapter.ViewItem

fun FilmDTO.toFilmInfo() =
    FilmInfo(
        id = id,
        localized_name = localized_name,
        name = name,
        year = year,
        rating = rating,
        image_url = image_url ?: " ",
        description = description ?: "",
        genres = genres
    )

fun String.toViewItemGenre() = ViewItem.Genre(genre = this)




fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoof: Boolean = false): View = let {
    LayoutInflater.from(context).inflate(layout, it, attachToRoof)
}