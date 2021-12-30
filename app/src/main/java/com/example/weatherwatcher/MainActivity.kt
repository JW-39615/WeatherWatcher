package com.example.weatherwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherwatcher.data.WeatherList
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_KEY = "f8186d62efc31be127a6ceac93dcc24c"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadWeather()
    }

    private fun loadWeather() {
        val destinationService = ServiceBuilder.buildService(WeatherService::class.java)
        //TODO: Get location from search bar
        val requestCall = destinationService.getCurrentWeatherByCityName("Legnica", API_KEY)

        requestCall.enqueue(object : Callback<WeatherList>{
            override fun onResponse(call: Call<WeatherList>, response: Response<WeatherList>) {
                Log.d(TAG, "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val  weather = response.body()!!
                    Log.d(TAG, "Weather: ${weather}")
                }
            }

            override fun onFailure(call: Call<WeatherList>, t: Throwable) {
                Log.d(TAG, "Something went wrong")
            }
        })
    }
}