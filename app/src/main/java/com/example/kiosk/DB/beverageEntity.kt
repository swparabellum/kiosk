package com.example.kiosk.DB

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "beverage_list",
    foreignKeys = [
        ForeignKey(
            entity = categoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryNo"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["categoryNo"])]
)
data class beverageEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val beverageName : String,
    val categoryNo : Long,
    val isUsed : Boolean = true
)