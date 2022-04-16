package com.krayapp.sekvtestapp.model

import com.krayapp.sekvtestapp.model.remoteAccess.FilmSource
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.model.remoteAccess.toFilmInfo
import retrofit2.HttpException

class MainRepo(private val remoteAccess: FilmSource) : IMainRepo {

    override suspend fun getRemoteFilmList(): List<FilmInfo> {
        try {
            val response = remoteAccess.getMovieList()
            return if (response.isSuccessful) {
                (response.body()!!.films.map { it.toFilmInfo() })
            } else {
                listOf(FilmInfo(0, "0", 0, 0.0, "", "", listOf()))
            }
        } catch (e: HttpException) {
            throw Exception(e)
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}