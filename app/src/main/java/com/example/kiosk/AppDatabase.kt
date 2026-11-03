package com.example.kiosk

import androidx.room.Database
import androidx.room.RoomDatabase

//@Dao
//interface KioskDao {
//    // Define your DAO methods here
//}

@Database(entities = [], version = 1)
abstract class AppDatabase : RoomDatabase() {
}