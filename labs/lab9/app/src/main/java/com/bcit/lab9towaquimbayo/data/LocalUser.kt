package com.bcit.lab9towaquimbayo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class LocalUser(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "first_name") val name: String,
    @ColumnInfo(name = "user_email") val email: String,
)