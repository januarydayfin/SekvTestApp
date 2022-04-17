package com.krayapp.sekvtestapp.view.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.OpenedFilmFragment

class OpenedFilmScreen(private val filmInfo: FilmInfo):FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        OpenedFilmFragment.newInstance(filmInfo)
}