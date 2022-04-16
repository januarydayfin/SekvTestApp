package com.krayapp.sekvtestapp.model.remoteAccess

import retrofit2.Response
import retrofit2.http.GET

interface FilmSource {
    @GET("sequeniatesttask/films.json")
    fun getMovieList():Response<FilmResponseDTO>
}