package com.krayapp.sekvtestapp.model

import com.krayapp.sekvtestapp.model.remoteAccess.FilmSource
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.toFilmInfo
import com.krayapp.sekvtestapp.toViewItemGenre
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import retrofit2.HttpException

class MainRepo(private val remoteAccess: FilmSource) : IMainRepo {

    private var genreSectionList: List<ViewItem> = mutableListOf()

    private val unformattedFilmList:MutableList<FilmInfo> = mutableListOf()


    override fun getServerData() {
        val unformattedGenreList: MutableList<String> = mutableListOf()
        try {
            val response = remoteAccess.getMovieList()
            if (response.isSuccessful) {
                response.body()!!.films.map {
                    unformattedFilmList.add(it.toFilmInfo())
                    unformattedGenreList.addAll(it.genres)
                }
            } else {
                throw Exception("Ошибка на уровне запроса ${response.body()}")
            }
            unformattedGenreList.sortBy { it }
            appendGenreList(unformattedGenreList)
        } catch (e: HttpException) {
            throw Exception(e)
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

    private fun setFilmListByGenre(genre: String):MutableList<ViewItem> {
        val filmList:MutableList<ViewItem> = mutableListOf()
        val arrayForSort:MutableList<FilmInfo> = mutableListOf()
        for (film in unformattedFilmList){
            if(film.genres.contains(genre)){
                arrayForSort.add(film)
            }
        }
        arrayForSort.sortBy { it.localized_name }
        for (item in arrayForSort){
            filmList.add(ViewItem.Film(item))
        }
        return filmList
    }

    override fun getInitiateList():MutableList<ViewItem> {
        val list = mutableListOf<ViewItem>()
        list.add(ViewItem.Title("Жанры"))
        list.addAll(genreSectionList)
        list.add(ViewItem.Title("Фильмы"))
        return list
    }

    override fun getGenreFilmList(genre: String): MutableList<ViewItem> {
        val filmList:MutableList<ViewItem> = setFilmListByGenre(genre)
        val list = mutableListOf<ViewItem>()
        list.add(ViewItem.Title("Жанры"))
        list.addAll(genreSectionList)
        list.add(ViewItem.Title("Фильмы"))
        list.addAll(filmList)
        return list
    }


    private fun appendGenreList(list: MutableList<String>) {
        val genreList: MutableList<ViewItem> = mutableListOf()
        list.distinct()
        for (genre in list) {
            genreList.add(genre.toViewItemGenre())
        }
        genreSectionList = genreList
    }
}