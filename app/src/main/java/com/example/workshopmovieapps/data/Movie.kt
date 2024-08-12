package com.example.workshopmovieapps.data

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.workshopmovieapps.R

data class Movie(
    @DrawableRes
    val img:Int
)

fun getMovieList(context:Context):List<Movie>{
    val listMovie = mutableListOf<Movie>()
    listMovie.clear()
    listMovie.add(
        Movie(
            R.drawable.img_movie4
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4
        )
    )
    return listMovie
}