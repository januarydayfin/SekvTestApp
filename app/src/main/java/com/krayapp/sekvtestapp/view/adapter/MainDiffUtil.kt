package com.krayapp.sekvtestapp.view.adapter

import androidx.recyclerview.widget.DiffUtil

class MainDiffUtil:DiffUtil.ItemCallback<MainListRecyclerViewItem.Film>() {
    override fun areItemsTheSame(
        oldItem: MainListRecyclerViewItem.Film,
        newItem: MainListRecyclerViewItem.Film
    ): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(
        oldItem: MainListRecyclerViewItem.Film,
        newItem: MainListRecyclerViewItem.Film
    ): Boolean =
        oldItem.film.id == newItem.film.id

}