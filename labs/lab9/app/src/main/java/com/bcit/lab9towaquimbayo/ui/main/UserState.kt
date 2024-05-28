package com.bcit.lab9towaquimbayo.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.bcit.lab9towaquimbayo.data.LocalUser
import com.bcit.lab9towaquimbayo.data.UserRepository

class UserState(private val userRepository: UserRepository) {
    var users by mutableStateOf(userRepository.getAll())

    fun refresh() {
        users = userRepository.getAll()
    }

    fun insertEntity(user: LocalUser) {
        userRepository.insertEntity(user)
    }

    fun replace(user: LocalUser) {
        userRepository.replace(user)
    }

    fun delete(user: LocalUser) {
        userRepository.delete(user)
    }
}