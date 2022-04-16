package com.krayapp.sekvtestapp.view

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.krayapp.sekvtestapp.model.FilmInfo

class OpenedFilmFragment: Fragment() {
    companion object{
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(filmInfo: FilmInfo):Fragment{
            val newFrag = OpenedFilmFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY,filmInfo))
            return newFrag
        }
    }
}