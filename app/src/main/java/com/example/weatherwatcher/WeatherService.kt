package com.example.weatherwatcher

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_KEY = ""

interface WeatherService {

    @GET( "weather?lat={lat}&lon={lon}&appid{key}")
    fun getCurrentWeatherByCoordinates(
        @Path("lat") lat: Float,
        @Path("lon") lon: Float,
        @Path("key") API_KEY: String
    ): Call<WeatherData>

    @GET( "")
    fun getForecast(): Call<WeatherData>
}