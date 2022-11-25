package com.example.clean_code.data.storage

import com.example.clean_code.data.storage.model.User
interface UserStorage {
    fun saveUser(user: User): Boolean
    fun getUser(): User
}
