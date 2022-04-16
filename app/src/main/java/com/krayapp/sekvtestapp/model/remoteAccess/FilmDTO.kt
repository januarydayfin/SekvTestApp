package com.krayapp.sekvtestapp.model.remoteAccess

import com.google.gson.annotations.Expose

data class FilmResponseDTO(
    @Expose val films: List<FilmDTO>
)
data class FilmDTO(
    @Expose val id:Int,
    @Expose val name:String,
    @Expose val year:Int,
    @Expose val rating:Double?,
    @Expose val image_url:String,
    @Expose val description:String,
    @Expose val genres:List<String>
)
