package com.krayapp.sekvtestapp.view.adapter

import com.krayapp.sekvtestapp.model.FilmInfo

sealed class ViewItem(val type: TestType) {
    class Title(
        val title: String
    ) : ViewItem(TestType.TITLE)

    class Genre(
        val genre:String,
        val isPicked:Boolean = false
    ):ViewItem(TestType.GENRE)

    class Film(
        val film:FilmInfo
    ):ViewItem(TestType.FILM)
}