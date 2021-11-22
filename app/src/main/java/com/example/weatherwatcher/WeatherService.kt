package com.example.weatherwatcher

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_KEY = ""

interface WeatherService {

    @GET("weather?lat={lat}&lon={lon}&appid=$API_KEY")
    fun getCurrentWeatherByCoordinates(
        @Path("lat") lat: Float,
        @Path("lon") lon: Float
    ): Call<WeatherData>

    @GET( "")
    fun getForecast(): Call<WeatherData>
}