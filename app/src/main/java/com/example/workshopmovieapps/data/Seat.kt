package com.example.workshopmovieapps.data

data class Seat(
    val id: Int,
    var isSelected: Boolean,
    val isBooked: Boolean,
)

fun generateSeat(): List<Seat> {
    val list = ArrayList<Seat>();
    for (i in 1..99) {
        if (i == 38 || i == 40 || i == 41 ||
            i == 42 || i == 43 || i == 44 ||
            i == 48 || i == 49 || i == 57 ||
            i == 59 || i == 73 || i == 74
        )
            list.add(Seat(i, false, true))
        else
            list.add(Seat(i, false, false))

    }
    return list
}
