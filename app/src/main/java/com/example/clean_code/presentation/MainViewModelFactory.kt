package com.example.clean_code.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean_code.data.repository.UserRepositoryImpl
import com.example.clean_code.data.storage.sharedPref.SharedPreferencesUserStorage
import com.example.clean_code.domain.usecase.GetUserNameUseCase
import com.example.clean_code.domain.usecase.SaveUserNameCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPreferencesUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameCase by lazy {
        SaveUserNameCase(userRepository = userRepository)
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameCase) as T
    }
}
