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

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "f8186d62efc31be127a6ceac93dcc24c"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val weatherService = retrofit.create(WeatherService::class.java)

        weatherService.getCurrentWeatherByCityName("Lubin", API_KEY).enqueue(object: Callback<WeatherList> {
            override fun onResponse(
                call: Call<WeatherList>,
                response: Response<WeatherList>
            ) {
                Log.i(TAG, "onResponse $response")
                val weatherData = response.body()
                if (weatherData == null) {
                    Log.w(TAG, "Invalid body response")
                    return
                }
            }

            override fun onFailure(call: Call<WeatherList>, t: Throwable) {
                Log.e(TAG, "onFailure $t")
            }

        })
    }
}