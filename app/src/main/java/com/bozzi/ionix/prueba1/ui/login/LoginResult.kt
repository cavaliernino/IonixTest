package com.bozzi.ionix.prueba1.ui.login

import com.bozzi.ionix.prueba1.ui.task.TaskListView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: TaskListView? = null,
    val error: Int? = null
)