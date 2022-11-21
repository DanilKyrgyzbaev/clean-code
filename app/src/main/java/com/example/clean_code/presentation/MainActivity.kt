package com.example.clean_code.presentation // ktlint-disable package-name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clean_code.data.repository.UserRepositoryImpl
import com.example.clean_code.databinding.ActivityMainBinding
import com.example.clean_code.domain.models.SaveUserNameParam
import com.example.clean_code.domain.models.UserName
import com.example.clean_code.domain.usecase.GetUserNameUseCase
import com.example.clean_code.domain.usecase.SaveUserNameCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userRepository by lazy { UserRepositoryImpl(applicationContext) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameCase by lazy { SaveUserNameCase(userRepository = userRepository) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameCase.execute(param = params)
            binding.dataTextView.text = "Save result = $result"
        }
        binding.receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}
