package com.bcit.lab9towaquimbayo

import android.app.Application
import androidx.room.Room
import com.bcit.lab9towaquimbayo.data.AppDatabase
import com.bcit.lab9towaquimbayo.data.UserRepository

class MyApp : Application() {
    private val db by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my-cool-database")
            .allowMainThreadQueries()
            .build()
    }

    val userRepository by lazy {
        UserRepository(db.userDao())
    }
}