package com.krayapp.sekvtestapp

import com.krayapp.sekvtestapp.model.MainRepo
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.model.remoteAccess.RetrofitApi
import com.krayapp.sekvtestapp.presentation.MainListPresenter
import com.krayapp.sekvtestapp.presentation.OpenedFilmPresenter
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IOpenedFilmPresenter
import org.koin.dsl.module

object Koin {

    fun getModules() = module {
        single { RetrofitApi.getFromApi() }
        single<IMainRepo> { MainRepo(remoteAccess = get()) }

        single<IMainListPresenter> { MainListPresenter(repo = get()) }
        single<IOpenedFilmPresenter> { OpenedFilmPresenter() }
    }
}