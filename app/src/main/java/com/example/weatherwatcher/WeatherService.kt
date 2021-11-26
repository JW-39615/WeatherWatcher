package com.example.weatherwatcher

import com.example.weatherwatcher.data.WeatherDataList
import com.example.weatherwatcher.data.WeatherList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f8186d62efc31be127a6ceac93dcc24c"

interface WeatherService {

    @GET("weather")
    fun getCurrentWeatherByCityName(
        @Query("q") cityName: String,
        @Query("appid") API_KEY: String
    ): Call<WeatherList>

    @GET("weather")
    fun getCurrentWeatherByCoordinates(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("appid") API_KEY: String
    ): Call<WeatherList>


    // 5 Days, 3 hour forecast data

    @GET( "forecast?q={cityName}&appid=$API_KEY")
    fun getForecastByCityName(
        @Query("cityName") cityName: String
    ): Call<WeatherDataList>

    @GET("forecast?lat={lat}&lon={lon}&appid=$API_KEY")
    fun getForecastByCoordinates(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): Call<WeatherDataList>
}