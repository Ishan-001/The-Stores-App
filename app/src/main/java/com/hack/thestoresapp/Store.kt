package com.hack.thestoresapp

import android.location.Location

data class Store(
    val store_name: String,
    val address: String,
    val peak_time: String,
    val location: Location?,
    val type: String
)