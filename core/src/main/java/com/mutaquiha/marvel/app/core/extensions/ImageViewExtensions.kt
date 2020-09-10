package com.mutaquiha.marvel.app.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}