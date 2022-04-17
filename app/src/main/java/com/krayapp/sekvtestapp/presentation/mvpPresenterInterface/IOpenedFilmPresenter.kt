package com.krayapp.sekvtestapp.presentation.mvpPresenterInterface

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.mvpView.ActivityView
import com.krayapp.sekvtestapp.view.mvpView.OpenedFilmView

interface IOpenedFilmPresenter {
    fun updateFilmInfo(filmInfo: FilmInfo)
    fun updateTitle(title:String)
    fun onAttachView(view:OpenedFilmView)
    fun onAttachActivityView(view:ActivityView)
}