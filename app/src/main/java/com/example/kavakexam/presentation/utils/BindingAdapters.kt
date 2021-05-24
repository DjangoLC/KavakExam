package com.example.kavakexam.presentation.utils

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kavakexam.core.domain.Gnome

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String) {

    val options: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.mipmap.sym_def_app_icon)
        .error(R.mipmap.sym_def_app_icon)

    Glide.with(view.context)
        .load(url)
        .apply(options)
        .into(view)
}

@BindingAdapter("setup")
fun setup(view: GnomeDetailInfoView, gnome: Gnome) {
    view.setGnome(gnome)
}