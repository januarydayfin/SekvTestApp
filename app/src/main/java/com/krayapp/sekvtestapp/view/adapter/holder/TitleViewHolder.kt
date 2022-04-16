package com.krayapp.sekvtestapp.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.sekvtestapp.databinding.TitleTemplateBinding
import com.krayapp.sekvtestapp.view.adapter.ViewItem

class TitleViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val viewBinding = TitleTemplateBinding.bind(view)

    fun bind(item:ViewItem.Title){
        with(viewBinding){
            mainTitle.text = item.title
        }
    }
}