package com.example.weatherwatcher.data

import com.google.gson.annotations.SerializedName

data class WeatherDataSingle(
    @SerializedName("weather")
    val weather: WeatherList
)
