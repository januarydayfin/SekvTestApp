package com.krayapp.sekvtestapp

import com.github.terrakok.cicerone.Cicerone
import com.krayapp.sekvtestapp.model.remoteAccess.RetrofitApi
import org.koin.dsl.module

object Koin {
    private val cicerone = Cicerone.create()
    fun getModules() = module {
        single { RetrofitApi.getFromApi() }

        single { cicerone.router }
        single { cicerone.getNavigatorHolder() }
    }
}