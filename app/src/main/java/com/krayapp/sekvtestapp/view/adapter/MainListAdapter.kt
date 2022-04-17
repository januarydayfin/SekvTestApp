package com.krayapp.sekvtestapp.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.inflate
import com.krayapp.sekvtestapp.view.adapter.delegate.FilmDelegate
import com.krayapp.sekvtestapp.view.adapter.delegate.GenreDelegate
import com.krayapp.sekvtestapp.view.adapter.delegate.MainDelegate
import com.krayapp.sekvtestapp.view.adapter.holder.FilmViewHolder
import com.krayapp.sekvtestapp.view.adapter.holder.GenreViewHolder
import com.krayapp.sekvtestapp.view.adapter.holder.TitleViewHolder

class MainListAdapter(private val delegate:MainDelegate): ParentAdapter<ViewItem, RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(TestType.values()[viewType]){
            TestType.TITLE -> TitleViewHolder(parent.inflate(R.layout.title_template))
            TestType.GENRE -> GenreViewHolder(parent.inflate(R.layout.genre_template))
            TestType.FILM -> FilmViewHolder(parent.inflate(R.layout.film_template))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = list.getOrNull(position)){
            is ViewItem.Title -> (holder as? TitleViewHolder)?.bind(item)
            is ViewItem.Genre -> (holder as? GenreViewHolder)?.bind(item,delegate)
            is ViewItem.Film -> (holder as? FilmViewHolder)?.bind(item, delegate)
        }
    }

    override fun getItemViewType(position: Int): Int  = list[position].type.ordinal



}