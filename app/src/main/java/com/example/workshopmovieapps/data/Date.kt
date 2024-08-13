package com.example.workshopmovieapps.data

import android.content.Context

data class Date(
    val date:String,
    val day:String
)

fun getDateList(context: Context):List<Date>{
    val listDate = mutableListOf<Date>()
    listDate.clear()
    listDate.add(
        Date(
            "01 Jan",
            "HARI INI"
        )
    )
    listDate.add(
        Date(
            "02 Jan",
            "SENIN"
        )
    )
    listDate.add(
        Date(
            "03 Jan",
            "SELASA"
        )
    )
    listDate.add(
        Date(
            "04 Jan",
            "RABU"
        )
    )
    listDate.add(
        Date(
            "05 Jan",
            "KAMIS"
        )
    )
    return listDate
}
