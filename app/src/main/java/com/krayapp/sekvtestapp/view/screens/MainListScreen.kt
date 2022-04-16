package com.krayapp.sekvtestapp.view.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.sekvtestapp.view.MainListFragment

object MainListScreen:FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = MainListFragment.newInstance()
}