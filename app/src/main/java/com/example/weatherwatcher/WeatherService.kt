package com.example.weatherwatcher

import com.example.weatherwatcher.data.WeatherDataList
import com.example.weatherwatcher.data.WeatherList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

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

    @GET( "forecast")
    fun getForecastByCityName(
        @Query("cityName") cityName: String,
        @Query("appid") API_KEY: String
    ): Call<WeatherDataList>

    @GET("forecast")
    fun getForecastByCoordinates(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("appid") API_KEY: String
    ): Call<WeatherDataList>
}