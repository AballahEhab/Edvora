package com.abdallahehab.edvora

import com.abdallahehab.edvora.data.Ride
import java.util.*


enum class Stations(val code:Int) {
    Station1(13),
    Station2(25),
    Station3(41),
    Station4(48),
    Station5(59),
    Station6(64),
    Station7(75),
    Station8(81),
    Station9(91),
}

val ridesList:List<Ride> = listOf(
    Ride(2,20, listOf(20,39,40,42,54,63,72,88,98),98, Date(1644924365),"URl", "Maharashtra","Panvel"),
    Ride(2,20, listOf(20,39,40,42,54,63,72,88,98),98, Date(1644924365),"URl", "Maharashtra","Panvel"),
    Ride(2,20, listOf(20,39,40,42,54,63,72,88,98),98, Date(1644924365),"URl", "Maharashtra","Panvel"),
)

