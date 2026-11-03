package com.example.kiosk.DB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_list")
data class categoryEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val categoryName : String,
    val is_used : Boolean = true
)