package com.example.clean_code.di

import com.example.clean_code.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(getUserNameUseCase = get(), saveUserNameCase = get())
    }
}