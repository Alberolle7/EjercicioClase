package com.albertoOlle.ejercicioclase

import android.app.Application
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.albertoOlle.ejercicioclase.model.Repository

class App : Application() {
    val users: MutableList<Repository> = mutableListOf()
}

fun ImageView.imageUrl(url: String, placeholder: Int = R.mipmap.ic_launcher){
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .into(this)
}