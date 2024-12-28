package com.example.homeprjhc.data.api

import com.example.homeprjhc.data.model.network.WeatherResponse
import com.example.homeprjhc.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {

    @GET(Constants.WEATHER_ACTION)
    suspend fun getWeatherByCityName(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units:String,
    ): WeatherResponse
}