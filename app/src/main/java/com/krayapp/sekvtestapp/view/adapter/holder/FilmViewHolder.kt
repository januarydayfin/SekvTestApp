package com.krayapp.sekvtestapp.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.databinding.FilmTemplateBinding
import com.krayapp.sekvtestapp.databinding.TitleTemplateBinding
import com.krayapp.sekvtestapp.model.remoteAccess.ImageLoader
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class FilmViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding = FilmTemplateBinding.bind(view)
    private val imageLoader = ImageLoader

    fun bind(item: ViewItem.Film){
        with(viewBinding){
            title.text = item.film.localized_name
        }
        imageLoader.loadInto(item.film.image_url, viewBinding.previewImage)
    }
}