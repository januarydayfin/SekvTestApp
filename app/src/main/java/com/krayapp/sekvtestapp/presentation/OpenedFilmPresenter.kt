package com.krayapp.sekvtestapp.presentation

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IOpenedFilmPresenter
import com.krayapp.sekvtestapp.view.mvpView.ActivityView
import com.krayapp.sekvtestapp.view.mvpView.OpenedFilmView


class OpenedFilmPresenter:IOpenedFilmPresenter {
    private lateinit var currentView:OpenedFilmView
    private lateinit var activityTitleView:ActivityView

    private lateinit var filmInfo: FilmInfo

    override fun updateFilmInfo(filmInfo: FilmInfo) {
        this.filmInfo = filmInfo
        currentView.setFilmInfo(filmInfo)
        updateTitle(filmInfo.localized_name)
    }

    override fun updateTitle(title: String) {
       activityTitleView.changeTitle(title)
    }

    override fun onAttachView(view: OpenedFilmView) {
        currentView = view
    }

    override fun onAttachActivityView(view: ActivityView) {
        activityTitleView = view
    }


}