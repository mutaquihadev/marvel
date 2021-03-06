package com.mutaquiha.marvel.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mutaquiha.marvel.commons.ImageSize
import com.mutaquiha.marvel.commons.extensions.getImageUrl
import com.mutaquiha.marvel.commons.extensions.load
import com.mutaquiha.marvel.domain.entity.Comic

@BindingAdapter("comicImage")
fun setImageView(view: ImageView, comic: Comic?) {
    comic?.let {
        view.visibility = View.VISIBLE
        view.load(comic.getImageUrl(ImageSize.LANDSCAPE_LARGE))
    }
}

@BindingAdapter("app:showProgressIfNull")
fun showProgress(view: ProgressBar, comic: Comic?) {
    comic?.let {
        view.visibility = View.GONE
    } ?: run {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("description")
fun showDescription(view: TextView, comic: Comic?) {
    comic?.description?.let {
        if (it.isNotEmpty()) {
            view.visibility = View.VISIBLE
            view.text = it
        } else {
            view.visibility = View.GONE
        }
    } ?: run {
        view.visibility = View.GONE
    }
}

@BindingAdapter("price")
fun showPrice(view: TextView, comic: Comic?) {
    comic?.let {
        view.visibility = View.VISIBLE
        view.text = "${comic.price} $"
    } ?: run {
        view.visibility = View.GONE
    }
}