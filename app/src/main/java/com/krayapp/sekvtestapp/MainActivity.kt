package com.krayapp.sekvtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.sekvtestapp.view.screens.MainListScreen
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)

    private val navigationHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainListScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }
}