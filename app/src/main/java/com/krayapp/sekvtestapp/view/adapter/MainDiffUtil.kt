package com.krayapp.sekvtestapp.view.adapter

import androidx.recyclerview.widget.DiffUtil

class MainDiffUtil:DiffUtil.ItemCallback<ViewItem.Film>() {
    override fun areItemsTheSame(
        oldItem: ViewItem.Film,
        newItem: ViewItem.Film
    ): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(
        oldItem: ViewItem.Film,
        newItem: ViewItem.Film
    ): Boolean =
        oldItem.film.id == newItem.film.id

}