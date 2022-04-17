package com.krayapp.sekvtestapp.presentation

import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import kotlinx.coroutines.*


class MainListPresenter(private val repo: IMainRepo) : IMainListPresenter {
    private lateinit var mainView: MainListView
    private var baseJob: Job? = null
    private val baseScope = CoroutineScope(Dispatchers.IO + SupervisorJob())


    override fun onViewAttach(view: MainListView) {
        mainView = view
        baseJob?.cancel()
        baseJob = baseScope.launch {
            repo.getServerData()
            mainView.toast("Загрузка данных")
        }
    }

    override fun onGenreSelect(genre: String) {
        mainView.setList(repo.getGenreFilmList(genre).toList())
        mainView.toast("Загрузка фильмов по жанру $genre")
    }


    override fun getInitiateList() {
       mainView.setList(repo.getInitiateList().toList())
    }

}