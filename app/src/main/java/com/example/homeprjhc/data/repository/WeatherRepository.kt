package com.example.homeprjhc.data.repository

import com.example.homeprjhc.data.model.entity.City
import com.example.homeprjhc.data.model.network.DataOrException
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun searchCityWeather(cityName: String): DataOrException<Boolean, Boolean, Exception>
    fun fetchAllCities(): Flow<List<City>>
}