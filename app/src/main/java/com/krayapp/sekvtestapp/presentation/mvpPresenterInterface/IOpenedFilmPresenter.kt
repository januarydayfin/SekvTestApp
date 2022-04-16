package com.krayapp.sekvtestapp.presentation.mvpPresenterInterface

import com.krayapp.sekvtestapp.model.FilmInfo

interface IOpenedFilmPresenter {
    fun updateFilmInfo(filmInfo: FilmInfo)
}