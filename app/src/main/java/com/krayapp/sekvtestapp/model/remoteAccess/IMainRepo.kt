package com.krayapp.sekvtestapp.model.remoteAccess

import com.krayapp.sekvtestapp.model.FilmInfo

interface IMainRepo {
    suspend fun getRemoteFilmList():List<FilmInfo>
}