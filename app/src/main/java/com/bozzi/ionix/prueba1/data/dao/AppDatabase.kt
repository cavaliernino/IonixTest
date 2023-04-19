package com.bozzi.ionix.prueba1.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bozzi.ionix.prueba1.data.model.Task
import com.bozzi.ionix.prueba1.data.model.User
import com.bozzi.ionix.prueba1.data.model.UserWithTasks

@Database(entities = [User::class, Task::class, UserWithTasks::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
    abstract fun userAndTaskDao(): UserWithTasksDao
}