package com.krayapp.sekvtestapp.view.adapter

sealed class MainListRecyclerViewItem {
    class Title(
        val id: Int,
        val title: String
    ) : MainListRecyclerViewItem()
    class Genre(
        val genre:String,
    ):MainListRecyclerViewItem()
    class Film(
        val title:String,
        val image:String
    )
}