package com.example.homeprjhc.data.model.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homeprjhc.data.model.entity.City

@Database(entities = [City::class], version= 1, exportSchema = false)
abstract class HcDataBase: RoomDatabase() {
    abstract fun cityDao(): CityDao
}