package com.example.homeprjhc.data.repository

import android.util.Log
import androidx.room.withTransaction
import com.example.homeprjhc.data.api.WeatherAPI
import com.example.homeprjhc.data.model.dao.HcDataBase
import com.example.homeprjhc.data.model.entity.City
import com.example.homeprjhc.data.model.network.DataOrException
import com.example.homeprjhc.data.model.network.WeatherResponse
import com.example.homeprjhc.util.Constants.API_KEY
import com.example.homeprjhc.util.Constants.TEMP_UNIT
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImp @Inject constructor(
    private val weatherAPI: WeatherAPI,
    private val dataBase: HcDataBase
) : WeatherRepository {
    override suspend fun searchCityWeather(cityName: String): DataOrException<Boolean, Boolean, Exception> {
        val dataOrException = DataOrException<Boolean, Boolean, Exception>()
        try {
            dataOrException.loading = true
            val response = weatherAPI.getWeatherByCityName(cityName, API_KEY, TEMP_UNIT)
            response.id?.let { id ->
                dataOrException.data = true
                val city = createCityFromResponse(response, id)
                dataBase.cityDao().insert(city)
            } ?: run {
                throw Exception("Saving Error")
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
        }

        return dataOrException
    }

    override fun fetchAllCities(): Flow<List<City>> = dataBase.cityDao().fetchAllCities().flowOn(Dispatchers.IO)

    private fun createCityFromResponse(response: WeatherResponse, id: Int): City {
        return City(
            id = id,
            name = response.name ?: "",
            weather = response.weather?.get(0)?.main ?: "",
            temperature = response.main?.temp.toString() ?: ""
        )
    }


}