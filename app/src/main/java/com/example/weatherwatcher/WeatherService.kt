package com.example.weatherwatcher

import com.example.weatherwatcher.data.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_KEY = "f8186d62efc31be127a6ceac93dcc24c"

interface WeatherService {

    @GET("weather?q={cityName}&appid=$API_KEY")
    fun getCurrentWeatherByCityName(
        @Path("cityName") cityName: String
    ): Call<WeatherData>

    @GET("weather?lat={lat}&lon={lon}&appid=$API_KEY")
    fun getCurrentWeatherByCoordinates(
        @Path("lat") lat: Float,
        @Path("lon") lon: Float
    ): Call<WeatherData>


    // 5 Days, 3 hour forecast data

    @GET( "forecast?q={cityName}&appid=$API_KEY")
    fun getForecastByCityName(
        @Path("cityName") cityName: String
    ): Call<WeatherData>

    @GET("forecast?lat={lat}&lon={lon}&appid=$API_KEY")
    fun getForecastByCoordinates(
        @Path("lat") lat: Float,
        @Path("lon") lon: Float
    ): Call<WeatherData>
}