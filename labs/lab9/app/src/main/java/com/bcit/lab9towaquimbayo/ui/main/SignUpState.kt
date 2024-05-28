package com.bcit.lab9towaquimbayo.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignUpState {
    var uid by mutableStateOf("")
    var onUidChanged: (String) -> Unit = { uid = it }
    var name by mutableStateOf("")
    val onNameChanged: (String) -> Unit = { name = it }
    var email by mutableStateOf("")
    val onEmailChanged: (String) -> Unit = { email = it }
}