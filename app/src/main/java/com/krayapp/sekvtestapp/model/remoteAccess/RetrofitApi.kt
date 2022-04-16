package com.krayapp.sekvtestapp.model.remoteAccess

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    fun getFromApi(): FilmSource =
        Retrofit.Builder()
            .baseUrl("https://s3-eu-west-1.amazonaws.com/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
            .create(FilmSource::class.java)
}