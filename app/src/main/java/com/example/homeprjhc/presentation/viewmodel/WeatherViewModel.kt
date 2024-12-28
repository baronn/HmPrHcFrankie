package com.example.homeprjhc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeprjhc.data.model.entity.City
import com.example.homeprjhc.domain.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase): ViewModel() {

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> = _cities

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<Boolean>(false)
    val error: StateFlow<Boolean> = _error

    init {
        viewModelScope.launch(Dispatchers.IO) {
            weatherUseCase.getCities()
                .collect { list ->
                    if (list.isNotEmpty())
                        _cities.value = list
                }
        }
    }
    fun searchCityWeather(cityName: String) {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val response = weatherUseCase.getCityWeather(cityName)
            delay(5000L)
            if(response.data == true){
                _loading.value = false
            } else if(!response.e?.message.isNullOrEmpty() ){
                _loading.value = false
                _error.value = true
            }
        }
    }

    fun closeAlertDialog(){
        _error.value = false
    }

}