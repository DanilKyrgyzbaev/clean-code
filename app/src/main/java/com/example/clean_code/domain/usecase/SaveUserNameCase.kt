package com.example.clean_code.domain.usecase

import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.repository.UserRepository

class SaveUserNameCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result: Boolean = userRepository.saveUserName(saveUserNameParam = param)
        return result
    }
}