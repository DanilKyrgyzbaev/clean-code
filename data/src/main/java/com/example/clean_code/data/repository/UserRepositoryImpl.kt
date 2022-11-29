package com.example.clean_code.data.repository // ktlint-disable package-name

import com.example.clean_code.data.storage.UserStorage
import com.example.clean_code.data.storage.model.User
import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.models.UserName
import com.example.clean_code.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveUserName(saveUserNameParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveUserNameParam.name, lastName = "")
        return userStorage.saveUser(user)
    }

    override fun getUserName(): UserName {
        val user = userStorage.getUser()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}
