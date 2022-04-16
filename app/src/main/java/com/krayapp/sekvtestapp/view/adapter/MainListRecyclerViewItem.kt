package com.krayapp.sekvtestapp.view.adapter

import com.krayapp.sekvtestapp.model.FilmInfo

sealed class MainListRecyclerViewItem(val type: TestType) {
    class Title(
        val id: Int,
        val title: String
    ) : MainListRecyclerViewItem(TestType.TITLE)
    class Genre(
        val genre:String,
    ):MainListRecyclerViewItem(TestType.GENRE)
    class Film(
        val film:FilmInfo
    ):MainListRecyclerViewItem(TestType.FILM)
}