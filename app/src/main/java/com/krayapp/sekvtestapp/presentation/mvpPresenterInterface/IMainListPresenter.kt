package com.krayapp.sekvtestapp.presentation.mvpPresenterInterface

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import com.krayapp.sekvtestapp.view.mvpView.MainListView

interface IMainListPresenter {
    fun onViewAttach(view:MainListView)
    fun onGenreSelect(genre:String)
    fun getInitiateList()
}