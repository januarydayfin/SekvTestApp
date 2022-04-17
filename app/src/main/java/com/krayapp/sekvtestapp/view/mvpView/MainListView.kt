package com.krayapp.sekvtestapp.view.mvpView

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.adapter.ViewItem


interface MainListView {
    fun setFilmList(list:List<ViewItem>)
}