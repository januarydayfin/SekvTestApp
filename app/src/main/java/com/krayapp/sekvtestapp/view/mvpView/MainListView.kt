package com.krayapp.sekvtestapp.view.mvpView

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.adapter.ViewItem


interface MainListView {
    fun setDefaultList(list:List<ViewItem>)
    fun setFilmList(list:List<ViewItem>, from:Int, to:Int)
    fun toast(message:String)
    fun onLoad()
    fun onLoadSuccess()
}