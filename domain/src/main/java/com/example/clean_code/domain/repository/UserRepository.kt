package com.example.clean_code.domain.repository

import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.models.UserName

interface UserRepository {
    fun saveUserName(saveUserNameParam: SaveUserNameParam): Boolean

    fun getUserName(): UserName
}