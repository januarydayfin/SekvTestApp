package com.krayapp.sekvtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.sekvtestapp.view.MainListFragment
import com.krayapp.sekvtestapp.view.adapter.holder.GenreViewHolder
import com.krayapp.sekvtestapp.view.screens.MainListScreen
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)

    private val navigationHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainListFragment.newInstance())
                .commitAllowingStateLoss()
        }
        GenreViewHolder.blueColor = baseContext.getColor(R.color.light_blue)
        GenreViewHolder.greyColor = baseContext.getColor(R.color.grey)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }
}