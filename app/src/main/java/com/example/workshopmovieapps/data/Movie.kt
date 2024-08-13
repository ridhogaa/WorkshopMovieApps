package com.example.workshopmovieapps.data

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.workshopmovieapps.R

data class Movie(
    @DrawableRes
    val img:Int,
    val id: Int,
)

fun getMovieList(context:Context):List<Movie>{
    val listMovie = mutableListOf<Movie>()
    listMovie.clear()
    listMovie.add(
        Movie(
            R.drawable.img_movie4,
            1
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4,
            2
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4,
            3
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4,
            4
        )
    )
    listMovie.add(
        Movie(
            R.drawable.img_movie4,
            5
        )
    )
    return listMovie
}