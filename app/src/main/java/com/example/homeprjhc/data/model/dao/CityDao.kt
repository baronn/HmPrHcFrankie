package com.example.homeprjhc.data.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.homeprjhc.data.model.entity.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao: BaseDao<City> {

    @Query("SELECT * FROM city Order By name")
    fun fetchAllCities(): Flow<List<City>>
}