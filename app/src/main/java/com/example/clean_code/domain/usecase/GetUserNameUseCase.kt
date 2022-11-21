package com.example.clean_code.domain.usecase

import com.example.clean_code.domain.models.UserName
import com.example.clean_code.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getUserName()
    }
}