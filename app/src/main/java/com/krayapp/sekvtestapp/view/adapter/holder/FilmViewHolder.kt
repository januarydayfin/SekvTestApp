package com.krayapp.sekvtestapp.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.databinding.FilmTemplateBinding
import com.krayapp.sekvtestapp.model.remoteAccess.ImageLoader
import com.krayapp.sekvtestapp.view.adapter.delegate.FilmDelegate
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class FilmViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding = FilmTemplateBinding.bind(view)
    private val imageLoader = ImageLoader

    fun bind(item: ViewItem.Film, filmDelegate: FilmDelegate){
        with(viewBinding){
            title.text = item.film.localized_name
            root.setOnClickListener{
                filmDelegate.onFilmPicked(item.film)
            }
        }
        imageLoader.loadPreview(item.film.image_url, viewBinding.previewImage)
    }
}