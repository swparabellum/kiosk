package com.example.kiosk.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [categoryEntity::class, beverageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
}