package com.krayapp.sekvtestapp.view.adapter

import com.krayapp.sekvtestapp.model.FilmInfo

sealed class ViewItem(val type: TestType) {
    class Title(
        val id: Int,
        val title: String
    ) : ViewItem(TestType.TITLE)
    class Genre(
        val genre:String,
    ):ViewItem(TestType.GENRE)
    class Film(
        val film:FilmInfo
    ):ViewItem(TestType.FILM)
}