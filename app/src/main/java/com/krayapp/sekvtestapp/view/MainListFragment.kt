package com.krayapp.sekvtestapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.databinding.MainListLayoutBinding
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IMainListPresenter
import com.krayapp.sekvtestapp.view.adapter.MainListAdapter
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import com.krayapp.sekvtestapp.view.adapter.delegate.MainDelegate
import com.krayapp.sekvtestapp.view.mvpView.MainListView
import org.koin.android.ext.android.inject

class MainListFragment : Fragment(R.layout.main_list_layout), MainListView, MainDelegate {
    companion object {
        fun newInstance() = MainListFragment()
    }

    private val presenter: IMainListPresenter by inject()

    private lateinit var viewBinding: MainListLayoutBinding
    private val adapter = MainListAdapter(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewAttach(this)
        setupRecycler()
        presenter.getInitiateList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = MainListLayoutBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    private fun setupRecycler() {
        val spanCount = 4
        val oneColumn = spanCount / 1
        val twoColumn = spanCount / 2

        val layoutManager = GridLayoutManager(context, spanCount)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemList().getOrNull(position)) {
                    is ViewItem.Title -> oneColumn
                    is ViewItem.Genre -> oneColumn
                    is ViewItem.Film -> twoColumn
                    null -> oneColumn
                }
            }
        }

        with(viewBinding) {
            mainRecycler.layoutManager = layoutManager
            mainRecycler.adapter = adapter
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setDefaultList(list: List<ViewItem>) {
        adapter.setList(list).notifyDataSetChanged()
    }

    override fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoad() {
        viewBinding.mainRecycler.visibility = View.INVISIBLE
        viewBinding.loadingLayout.loadingLayout.visibility = View.VISIBLE
    }

    override fun onLoadSuccess() {
        viewBinding.mainRecycler.visibility = View.VISIBLE
        viewBinding.loadingLayout.loadingLayout.visibility = View.INVISIBLE
    }

    override fun onClickGenre(genre: String) {
        presenter.onGenreSelect(genre)
    }


    override fun onFilmPicked(filmInfo: FilmInfo) {
        requireActivity().supportFragmentManager.apply {
            beginTransaction()
                .add(R.id.container, OpenedFilmFragment.newInstance(filmInfo))
                .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
    }
}
