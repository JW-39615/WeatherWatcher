package com.example.weatherwatcher.data

import com.google.gson.annotations.SerializedName

data class WeatherList(
    @SerializedName("dt")
    val dt: String,

    @SerializedName("main")
    val main: Main,

    @SerializedName("weather")
    val weather: List<WeatherObject>,

    @SerializedName("dt_txt")
    val dt_txt: String,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("wind")
    val wind: Wind
)