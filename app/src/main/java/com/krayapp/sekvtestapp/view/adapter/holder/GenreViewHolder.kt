package com.krayapp.sekvtestapp.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.databinding.GenreTemplateBinding
import com.krayapp.sekvtestapp.view.adapter.GenreDelegate
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class GenreViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding = GenreTemplateBinding.bind(view)

    fun bind(item: ViewItem.Genre, delegate:GenreDelegate){
        with(viewBinding){
            genre.text = item.genre
            root.setOnClickListener{
                delegate.onClickGenre(item.genre)
            }
        }
    }
}