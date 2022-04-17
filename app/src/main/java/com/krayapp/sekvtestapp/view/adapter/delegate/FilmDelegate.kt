package com.krayapp.sekvtestapp.view.adapter.delegate

import com.krayapp.sekvtestapp.model.FilmInfo

interface FilmDelegate {
    fun onFilmPicked(filmInfo: FilmInfo)
}