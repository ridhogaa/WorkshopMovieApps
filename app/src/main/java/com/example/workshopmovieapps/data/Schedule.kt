package com.example.workshopmovieapps.data

import android.content.Context

data class Schedule(
    val time:String
)

fun getScheduleList(context: Context):List<Schedule>{
    val listSchedule = mutableListOf<Schedule>()
    listSchedule.clear()
    listSchedule.add(
        Schedule(
            "11:30",
        )
    )
    listSchedule.add(
        Schedule(
            "13:00",
        )
    )
    listSchedule.add(
        Schedule(
            "14:30",
        )
    )
    listSchedule.add(
        Schedule(
            "16:00",
        )
    )
    listSchedule.add(
        Schedule(
            "18:00",
        )
    )
    return listSchedule
}