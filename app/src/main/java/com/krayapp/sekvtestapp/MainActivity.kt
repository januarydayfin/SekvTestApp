package com.krayapp.sekvtestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.krayapp.sekvtestapp.presentation.OpenedFilmPresenter
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IOpenedFilmPresenter
import com.krayapp.sekvtestapp.view.MainListFragment
import com.krayapp.sekvtestapp.view.adapter.holder.GenreViewHolder
import com.krayapp.sekvtestapp.view.mvpView.ActivityView
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), ActivityView {
    private val presenter:IOpenedFilmPresenter by inject()
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
        presenter.onAttachActivityView(this)
        changeTitle("Главная")
    }

    override fun changeTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onBackPressed() {
        changeTitle("Главная")
        super.onBackPressed()
    }

}