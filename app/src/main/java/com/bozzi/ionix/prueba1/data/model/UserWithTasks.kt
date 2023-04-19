package com.bozzi.ionix.prueba1.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class UserWithTasks(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "assigned_user"
    )
    val tasks: List<Task>
)