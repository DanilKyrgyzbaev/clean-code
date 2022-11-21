package com.example.clean_code.data.repository

import android.content.Context
import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.models.UserName
import com.example.clean_code.domain.repository.UserRepository

private const val SHAREDPREFERENCES_NAME = "shared_preferences_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"

class UserRepositoryImpl(private val context: Context) : UserRepository {
    private val sharedPreferences = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE)

    // пере определаем
    override fun saveUserName(saveUserNameParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveUserNameParam.name).apply()
        return true
    }

    override fun getUserName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "Default last name") ?: "Default last name"

        return UserName(firstName = firstName, lastName = lastName)
    }
}
