package com.bozzi.ionix.prueba1.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bozzi.ionix.prueba1.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE assigned_user = :userId ORDER BY expire_on ASC")
    fun getTaskByUserId(userId: String): Flow<Task>

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE assigned_user = :userId")
    fun getUserTasks(userId: String): Flow<List<Task>>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)
}