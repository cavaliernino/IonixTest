package com.bozzi.ionix.prueba1.data.dao

import androidx.room.Query
import androidx.room.Transaction
import com.bozzi.ionix.prueba1.data.model.UserWithTasks

interface UserWithTasksDao {
    @Transaction
    @Query("SELECT * FROM User")
    fun getUsersWithTasks(): List<UserWithTasks>
}