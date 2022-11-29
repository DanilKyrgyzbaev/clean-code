package com.example.clean_code.di

import com.example.clean_code.domain.usecase.GetUserNameUseCase
import com.example.clean_code.domain.usecase.SaveUserNameCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> { GetUserNameUseCase(userRepository = get())}
    factory<SaveUserNameCase> { SaveUserNameCase(userRepository = get())}
}