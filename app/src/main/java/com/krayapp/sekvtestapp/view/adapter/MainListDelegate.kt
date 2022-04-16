package com.krayapp.sekvtestapp.view.adapter

import com.krayapp.sekvtestapp.model.FilmInfo

interface MainListDelegate {
    fun onClickElement(filmInfo: FilmInfo)
}