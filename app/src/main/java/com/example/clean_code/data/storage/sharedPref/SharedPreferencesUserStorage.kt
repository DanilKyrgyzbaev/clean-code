package com.example.clean_code.data.storage.sharedPref

import android.content.Context
import com.example.clean_code.data.storage.UserStorage
import com.example.clean_code.data.storage.model.User

private const val SHAREDPREFERENCES_NAME = "shared_preferences_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_FIRST_NAME = "Default First name"
private const val DEFAULT_LAST_NAME = "Default last name"

class SharedPreferencesUserStorage(context: Context) : UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveUser(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(DEFAULT_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getUser(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }

}