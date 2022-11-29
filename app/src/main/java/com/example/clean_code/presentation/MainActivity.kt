package com.example.clean_code.presentation // ktlint-disable package-name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clean_code.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.resultLive.observe(this) {
            binding.dataTextView.text = it
        }
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            viewModel.save(text)
        }
        binding.receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}
