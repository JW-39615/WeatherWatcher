package com.example.weatherwatcher.data

import com.google.gson.annotations.SerializedName

//Cloudiness in %
data class Clouds(
    @SerializedName("all")
    val all: Int
)
