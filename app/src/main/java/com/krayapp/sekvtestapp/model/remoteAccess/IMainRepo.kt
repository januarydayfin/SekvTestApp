package com.krayapp.sekvtestapp.model.remoteAccess

import com.krayapp.sekvtestapp.model.FilmInfo
import com.krayapp.sekvtestapp.view.adapter.ViewItem

interface IMainRepo {
    suspend fun getServerData()
    fun getInitiateList():MutableList<ViewItem>
    fun getGenreFilmList(genre: String):MutableList<ViewItem>
    fun letGenreBlue(genreItem:String)
}