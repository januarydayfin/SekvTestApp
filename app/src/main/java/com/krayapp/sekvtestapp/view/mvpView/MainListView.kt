package com.krayapp.sekvtestapp.view.mvpView

import com.krayapp.sekvtestapp.model.FilmInfo


interface MainListView {
    fun setFilmList(list:List<FilmInfo>)
}