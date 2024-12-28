package com.example.homeprjhc.domain

import com.example.homeprjhc.data.model.entity.City
import com.example.homeprjhc.data.model.network.DataOrException
import com.example.homeprjhc.data.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherUseCaseImp @Inject constructor(private val repository: WeatherRepository): WeatherUseCase {
    override suspend fun getCityWeather(cityName: String): DataOrException<Boolean, Boolean, Exception> {
        return repository.searchCityWeather(cityName)
    }

    override suspend fun getCities(): Flow<List<City>> {
        return repository.fetchAllCities()
    }

}