package com.krayapp.sekvtestapp

import com.github.terrakok.cicerone.Cicerone
import com.krayapp.sekvtestapp.model.MainRepo
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.model.remoteAccess.RetrofitApi
import com.krayapp.sekvtestapp.view.viewModels.MainListViewModel
import com.krayapp.sekvtestapp.view.viewModels.OpenedFilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    private val cicerone = Cicerone.create()
    fun getModules() = module {
        single { RetrofitApi.getFromApi() }
        single<IMainRepo> { MainRepo(remoteAccess = get()) }

        single { cicerone.router }
        single { cicerone.getNavigatorHolder() }

        viewModel { MainListViewModel(get()) }
        viewModel { OpenedFilmViewModel() }
    }
}