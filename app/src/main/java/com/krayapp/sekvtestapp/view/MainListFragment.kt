package com.krayapp.sekvtestapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.databinding.MainListLayoutBinding
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.adapter.MainListAdapter
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import com.krayapp.sekvtestapp.view.adapter.delegate.MainDelegate
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import com.krayapp.sekvtestapp.view.screens.OpenedFilmScreen
import org.koin.android.ext.android.inject

class MainListFragment:Fragment(R.layout.main_list_layout), MainListView, MainDelegate {
    companion object{
        fun newInstance() = MainListFragment()
    }
    private val presenter: IMainListPresenter by inject()

    private val router:Router by inject()
    private val adapter = MainListAdapter(this)
    private lateinit var  recycler:RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewAttach(this)
        recycler = view.findViewById(R.id.main_recycler)
        setupRecycler()
        presenter.getInitiateList()
    }

    private fun setupRecycler(){
        val spanCount = 4
        val oneColumn = spanCount / 1
        val twoColumn = spanCount / 2

        val layoutManager = GridLayoutManager(context,spanCount)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemList().getOrNull(position)){
                    is ViewItem.Title -> oneColumn
                    is ViewItem.Genre -> oneColumn
                    is ViewItem.Film -> twoColumn
                    null -> oneColumn
                }
            }
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    override fun setList(list: List<ViewItem>) {
        adapter.setList(list).notifyDataSetChanged()
    }

    override fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onFilmPicked(filmInfo: FilmInfo) {
        //router.navigateTo(OpenedFilmScreen(filmInfo))
    }

    override fun onClickGenre(genre: String) {
        presenter.onGenreSelect(genre)
    }

}