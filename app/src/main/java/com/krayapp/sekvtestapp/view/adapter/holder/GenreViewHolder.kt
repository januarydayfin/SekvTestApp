package com.krayapp.sekvtestapp.view.adapter.holder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.databinding.GenreTemplateBinding
import com.krayapp.sekvtestapp.view.adapter.delegate.GenreDelegate
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class GenreViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding = GenreTemplateBinding.bind(view)

    @SuppressLint("ResourceAsColor")
    fun bind(item: ViewItem.Genre, delegate: GenreDelegate){
        with(viewBinding){
            genre.text = item.genre
            root.setOnClickListener{
                delegate.onClickGenre(item.genre)
            }
            root.setOnFocusChangeListener{_, hasFocus ->
                if (hasFocus){
                    root.setCardBackgroundColor(R.color.light_blue)
                }else{
                    root.setCardBackgroundColor(R.color.grey)
                }
            }
        }
    }
}