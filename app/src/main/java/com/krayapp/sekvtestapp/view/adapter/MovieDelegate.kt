package com.krayapp.sekvtestapp.view.adapter

import com.krayapp.sekvtestapp.model.FilmInfo

interface MovieDelegate {
    fun onMoviePicked(filmInfo: FilmInfo)
}