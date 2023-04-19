package com.bozzi.ionix.prueba1.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bozzi.ionix.prueba1.data.model.User

@Dao
interface UsersDao {
    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserByEmail(email: String): User

    @Insert
    fun register(user: User)

    @Delete
    fun delete(user: User)
}