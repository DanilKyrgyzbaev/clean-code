package com.example.clean_code.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.models.UserName
import com.example.clean_code.domain.usecase.GetUserNameUseCase
import com.example.clean_code.domain.usecase.SaveUserNameCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameCase: SaveUserNameCase
) : ViewModel() {
    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable
    init {
        Log.e("ololo", "VM crated")
    }

    override fun onCleared() {
        Log.e("ololo", "VM crated")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameCase.execute(param = params)
        resultLiveMutable.value = "Save = $result"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}
