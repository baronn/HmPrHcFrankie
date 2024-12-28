package com.example.homeprjhc.domain

import com.example.homeprjhc.data.model.entity.City
import com.example.homeprjhc.data.model.network.DataOrException
import kotlinx.coroutines.flow.Flow

interface WeatherUseCase {
    suspend fun getCityWeather(cityName: String): DataOrException<Boolean, Boolean, Exception>

    suspend fun getCities(): Flow<List<City>>
}