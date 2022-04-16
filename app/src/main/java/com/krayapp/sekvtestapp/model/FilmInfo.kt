package com.krayapp.sekvtestapp.model

import com.google.gson.annotations.Expose

data class FilmInfo(
    val id: Int,
    val name: String,
    val year: Int,
    val rating: Double?,
    val image_url: String,
    val description: String,
    val genres: List<String>
)
