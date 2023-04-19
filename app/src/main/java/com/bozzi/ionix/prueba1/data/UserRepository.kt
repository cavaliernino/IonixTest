package com.bozzi.ionix.prueba1.data

import com.bozzi.ionix.prueba1.data.model.Result
import com.bozzi.ionix.prueba1.data.model.User

class UserRepository(val dataSource: UserDataSource) {
    var user: User? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(email: String, password: String): Result<User> {
        var result = dataSource.login(email, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: User) {
        this.user = loggedInUser
    }
}