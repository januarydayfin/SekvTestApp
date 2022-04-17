package com.krayapp.sekvtestapp.view.adapter.holder

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.R
import com.krayapp.sekvtestapp.databinding.GenreTemplateBinding
import com.krayapp.sekvtestapp.view.adapter.delegate.GenreDelegate
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class GenreViewHolder (view: View): RecyclerView.ViewHolder(view) {
    companion object{
         var blueColor: Int = 0
         var greyColor: Int = 0
    }
    private val viewBinding = GenreTemplateBinding.bind(view)

    fun bind(item: ViewItem.Genre, delegate: GenreDelegate){
        with(viewBinding){
            genre.text = item.genre
            if (item.isPicked){
            }else{
                root.setCardBackgroundColor(greyColor)
            }
            root.setOnClickListener{
                root.setCardBackgroundColor(blueColor)
                delegate.onClickGenre(item.genre)
            }
            root.setOnFocusChangeListener{_, hasFocus ->
                if(!hasFocus) root.setCardBackgroundColor(greyColor)
            }
        }
    }
}