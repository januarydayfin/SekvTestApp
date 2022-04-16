package com.krayapp.sekvtestapp.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainListAdapter(private val delegate: GenreDelegate): ParentAdapter<ViewItem, RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(TestType.values()[viewType]){
            TestType.TITLE ->
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}