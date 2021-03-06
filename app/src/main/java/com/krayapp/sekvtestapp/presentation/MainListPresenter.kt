package com.krayapp.sekvtestapp.presentation

import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import kotlinx.coroutines.*


class MainListPresenter(private val repo: IMainRepo) : IMainListPresenter {
    private lateinit var mainView: MainListView
    private var baseJob: Job? = null
    private val baseScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    override fun onViewAttach(view: MainListView) {
        mainView = view
        mainView.onLoad()
    }

    override fun onGenreSelect(genre: String) {
        repo.letGenreBlue(genre)
        mainView.setDefaultList(repo.getGenreFilmList(genre).toList())
        mainView.toast("Загрузка фильмов по жанру $genre")
    }

    override fun getInitiateList() {
        baseJob?.cancel()
        baseJob = baseScope.launch {
            repo.getServerData()
            mainView.setDefaultList(repo.getInitiateList().toList())
            mainView.onLoadSuccess()
        }
    }

}