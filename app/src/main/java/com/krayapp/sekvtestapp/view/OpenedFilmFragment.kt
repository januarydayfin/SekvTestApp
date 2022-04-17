package com.krayapp.sekvtestapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.databinding.OpenedFilmFragmentBinding
import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.model.remoteAccess.ImageLoader
import com.krayapp.sekvtestapp.presentation.mvpPresenterInterface.IOpenedFilmPresenter
import com.krayapp.sekvtestapp.view.mvpView.OpenedFilmView
import org.koin.android.ext.android.inject

class OpenedFilmFragment: Fragment(R.layout.opened_film_fragment),OpenedFilmView {
    companion object{
        private const val FILM_KEY = "FILM_KEY"
        fun newInstance(filmInfo: FilmInfo):Fragment{
            val newFrag = OpenedFilmFragment()
            newFrag.arguments = bundleOf(Pair(FILM_KEY,filmInfo))
            return newFrag
        }
    }

    private lateinit var  viewBinding:OpenedFilmFragmentBinding
    private lateinit var currentFilmInfo: FilmInfo
    private val presenter:IOpenedFilmPresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = OpenedFilmFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
        currentFilmInfo = arguments?.getParcelable(FILM_KEY)!!
        presenter.updateFilmInfo(currentFilmInfo)
    }

    override fun setFilmInfo(filmInfo: FilmInfo) {
        with(viewBinding){
            originalName.text = filmInfo.name
            year.text = "Год ${filmInfo.year.toString()}"
            rating.text = "Рейтинг ${filmInfo.rating.toString()}"
            description.text = filmInfo.description
            ImageLoader.loadPoster(filmInfo.image_url, image)
            requireActivity().actionBar?.title = filmInfo.localized_name
        }
    }
}