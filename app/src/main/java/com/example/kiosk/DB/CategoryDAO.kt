package com.example.kiosk.DB

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDAO {

    @Query("SELECT categoryName FROM category_list ORDER BY id DESC")
    fun getCategory(): List<String>


}