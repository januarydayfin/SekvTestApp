package com.krayapp.sekvtestapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SekvApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@SekvApp)
            Koin.getModules()
        }
    }
}