package com.krayapp.sekvtestapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import org.koin.android.ext.android.inject

class MainListFragment:Fragment(), MainListView {
    companion object{
        fun newInstance() = MainListFragment()
    }

    private val presenter: IMainListPresenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewAttach(this)
    }

    override fun setFilmList(list: List<FilmInfo>) {
        TODO("Not yet implemented")
    }


}