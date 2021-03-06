package com.krayapp.sekvtestapp.model

import com.krayapp.sekvtestapp.model.remoteAccess.FilmSource
import com.krayapp.sekvtestapp.model.remoteAccess.IMainRepo
import com.krayapp.sekvtestapp.toFilmInfo
import com.krayapp.sekvtestapp.toUniqueFilmList
import com.krayapp.sekvtestapp.toUniqueGenreList
import com.krayapp.sekvtestapp.toViewItemGenre
import com.krayapp.sekvtestapp.view.adapter.ViewItem
import kotlinx.coroutines.*
import retrofit2.HttpException

class MainRepo(private val remoteAccess: FilmSource) : IMainRepo {

    private var genreSectionList: List<ViewItem> = mutableListOf()

    private val unformattedFilmList: MutableList<FilmInfo> = mutableListOf()

    private var defaultList: MutableList<ViewItem> = mutableListOf()

    private var unformattedGenreList: MutableList<String> = mutableListOf()


    //получает данные с сервера
    override suspend fun getServerData() {
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
        } catch (e: HttpException) {
            throw Exception(e)
        } catch (e: Exception) {
            throw Exception(e)
        }
        unformattedGenreList.sortBy { it }
        appendGenreList(unformattedGenreList)
    }

    //вспомогательная функция, удаляет дубли из списка жанров
    private fun appendGenreList(list: MutableList<String>) {
        val genreList: MutableList<ViewItem> = mutableListOf()
        for (genre in list.toSet().toList()) {
            genreList.add(genre.toViewItemGenre())
        }
        genreSectionList = genreList
    }

    //проверяет список фильмов на соответствие жанров и сортирует по локализованному названию
    private fun setFilmListByGenre(genre: String): MutableList<ViewItem> {
        val filmList: MutableList<ViewItem> = mutableListOf()
        val arrayForSort: MutableList<FilmInfo> = mutableListOf()
        for (film in unformattedFilmList.toUniqueFilmList()) {
            if (film.genres.contains(genre)) {
                arrayForSort.add(film)
            }
        }
        arrayForSort.sortBy { it.localized_name }
        for (item in arrayForSort) {
            filmList.add(ViewItem.Film(item))
        }
        return filmList
    }

    //отдает первый запрос, без фильмов, только тайтлы и жанры
    override fun getInitiateList(): MutableList<ViewItem> {
        defaultList.clear()
        defaultList.add(ViewItem.Title("Жанры"))
        defaultList.addAll(genreSectionList)
        defaultList.add(ViewItem.Title("Фильмы"))
        return defaultList
    }

    //отдает список с фильмами
    override fun getGenreFilmList(genre: String): MutableList<ViewItem> {
        val filmList: MutableList<ViewItem> = setFilmListByGenre(genre)
        val list = mutableListOf<ViewItem>()
        list.clear()
        list.add(ViewItem.Title("Жанры"))
        list.addAll(genreSectionList)
        list.add(ViewItem.Title("Фильмы"))
        list.addAll(filmList)
        return list
    }

    override fun letGenreBlue(genreItem: String) {
        val genreList: MutableList<ViewItem> = mutableListOf()
        for (item in unformattedGenreList.toUniqueGenreList()){
            if (item.equals(genreItem)){
                genreList.add(item.toViewItemGenre(true))
            }else{
                genreList.add(item.toViewItemGenre())
            }
            genreSectionList = genreList
        }
    }
}