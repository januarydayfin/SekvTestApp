package com.krayapp.sekvtestapp

import com.krayapp.sekvtestapp.model.RetrofitApi
import org.koin.dsl.module

object Koin {
    fun getModules() = module {
        single { RetrofitApi.getFromApi() }
    }
}