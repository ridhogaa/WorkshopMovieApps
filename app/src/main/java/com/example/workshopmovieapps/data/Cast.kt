package com.example.workshopmovieapps.data

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.workshopmovieapps.R

data class Cast(
    @DrawableRes
    val img:Int,
)

fun getCastList(context: Context):List<Cast>{
    val listCast = mutableListOf<Cast>()
    listCast.clear()
    listCast.add(
        Cast(
            R.drawable.img_cast1,
        )
    )
    listCast.add(
        Cast(
            R.drawable.img_cast2,
        )
    )
    listCast.add(
        Cast(
            R.drawable.img_cast3,
        )
    )
    listCast.add(
        Cast(
            R.drawable.img_cast4,
        )
    )
    return listCast
}
