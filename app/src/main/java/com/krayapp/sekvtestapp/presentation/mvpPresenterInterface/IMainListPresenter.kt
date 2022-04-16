package com.krayapp.sekvtestapp.presentation.mvpPresenterInterface

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.mvpView.MainListView

interface IMainListPresenter {
    fun showInfoByFilm(filmInfo: FilmInfo)
    fun onViewAttach(view:MainListView)
}