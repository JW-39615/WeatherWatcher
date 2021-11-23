package com.example.weatherwatcher.data

data class WeatherList(
    val dt: String,
    val main: Main,
    val weather: List<WeatherObject>,
    val dt_txt: String,
    val clouds: Clouds,
    val wind: Wind
)