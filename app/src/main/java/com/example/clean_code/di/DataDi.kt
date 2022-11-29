package com.example.clean_code.di

import com.example.clean_code.data.repository.UserRepositoryImpl
import com.example.clean_code.data.storage.UserStorage
import com.example.clean_code.data.storage.sharedPref.SharedPreferencesUserStorage
import com.example.clean_code.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> { SharedPreferencesUserStorage(context = get()) }
    single<UserRepository> { UserRepositoryImpl(userStorage = get()) }
}