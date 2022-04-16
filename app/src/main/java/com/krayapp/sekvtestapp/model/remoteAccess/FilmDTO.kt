package com.krayapp.sekvtestapp.model.remoteAccess

import com.google.gson.annotations.Expose
import com.krayapp.sekvtestapp.model.FilmInfo

data class FilmResponseDTO(
    @Expose val films: List<FilmDTO>
)

data class FilmDTO(
    @Expose val id: Int,
    @Expose val localized_name:String,
    @Expose val name: String,
    @Expose val year: Int,
    @Expose val rating: Double?,
    @Expose val image_url: String,
    @Expose val description: String,
    @Expose val genres: List<String>
)

fun FilmDTO.toFilmInfo() =
    FilmInfo(
        id = id,
        name = name,
        year = year,
        rating = rating,
        image_url = image_url,
        description = description,
        genres = genres
    )

