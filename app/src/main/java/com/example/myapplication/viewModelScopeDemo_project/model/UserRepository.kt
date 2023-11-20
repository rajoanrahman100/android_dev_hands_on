package com.example.myapplication.viewModelScopeDemo_project.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser():List<User>{
        delay(timeMillis = 8000)
        val user: List<User> = listOf(
            User(id = 1, name = "Rifat"),
            User(id = 2, name = "Bristy"),
            User(id = 3, name = "Ihan"),
            User(id = 4, name = "Arisha")
        )

        return user
    }
}