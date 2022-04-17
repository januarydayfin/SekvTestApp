package com.krayapp.sekvtestapp.presentation

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import kotlinx.coroutines.*


class MainListPresenter(private val repo: IMainRepo) : IMainListPresenter {
    private lateinit var mainListView: MainListView
    private var baseJob: Job? = null
    private val baseScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun showInfoByFilm(filmInfo: FilmInfo) {
        TODO("Not yet implemented")
    }

    override fun onViewAttach(view: MainListView) {
        mainListView = view
        baseJob?.cancel()
        baseJob = baseScope.async {
           mainListView.setFilmList(repo.getServerData())
        }
    }

    override fun onGenreSelect(genre: String) {
        TODO("Not yet implemented")
    }


}