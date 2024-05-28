package com.bcit.lab9towaquimbayo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users_table")
    fun getAll(): List<LocalUser>

    @Insert
    fun insertAll(user: LocalUser)

    @Delete
    fun delete(user: LocalUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun replace(user: LocalUser)
}