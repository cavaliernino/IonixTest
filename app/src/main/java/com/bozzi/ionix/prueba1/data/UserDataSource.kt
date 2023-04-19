package com.bozzi.ionix.prueba1.data

import com.bozzi.ionix.prueba1.data.model.Result
import com.bozzi.ionix.prueba1.data.model.User
import java.io.IOException

class UserDataSource {

    fun login(username: String, password: String): Result<User> {
        return try {
            val userId = User(java.util.UUID.randomUUID().toString(), "user@ionix.cl", "1234",0, 0)
            Result.Success(userId)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {

    }
}