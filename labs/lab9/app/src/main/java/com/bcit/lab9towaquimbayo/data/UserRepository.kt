package com.bcit.lab9towaquimbayo.data

class UserRepository(private val userDao: UserDao) {
    fun insertEntity(user: LocalUser) {
        userDao.insertAll(user)
    }

    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }

    fun replace(user: LocalUser) {
        userDao.replace(user)
    }

    fun delete(user: LocalUser) {
        userDao.delete(user)
    }
}
