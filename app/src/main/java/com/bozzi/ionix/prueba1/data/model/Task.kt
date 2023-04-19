package com.bozzi.ionix.prueba1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Task (
    @PrimaryKey val uid: Int,
    val title: String = "",
    val description: String = "",
    @ColumnInfo(name = "completed") var isCompleted: Boolean = false,
    @ColumnInfo(name = "expire_on") val expireOn: Long = 0,
    @ColumnInfo(name = "assigned_user") val assignedUser: String?
    ) {

    val titleForList: String
        get() = title.ifEmpty { description }

    val isActive
        get() = !isCompleted

    val isEmpty
        get() = title.isEmpty() || description.isEmpty()

    val isExpired
        get() = expireOn > System.currentTimeMillis()
}