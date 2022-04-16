package com.krayapp.sekvtestapp.model

data class FilmInfo(
    val id: Int,
    val localized_name:String,
    val name: String,
    val year: Int,
    val rating: Double?,
    val image_url: String,
    val description: String,
    val genres: List<String>
)
