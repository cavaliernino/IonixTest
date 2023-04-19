package com.bozzi.ionix.prueba1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class User(
    @PrimaryKey @ColumnInfo(name = "user_id") val userId: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String = "",
    @ColumnInfo(name = "profile") val profile: Int = 0,
    @ColumnInfo(name = "status") val status: Int = 0
)