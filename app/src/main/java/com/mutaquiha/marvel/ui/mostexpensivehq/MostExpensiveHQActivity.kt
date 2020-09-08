package com.mutaquiha.marvel.ui.mostexpensivehq

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mutaquiha.marvel.databinding.ActivityMostExpensiveHQBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostExpensiveHQActivity : AppCompatActivity() {

    private val viewModel: MostExpensiveHQViewModel by viewModels()
    private lateinit var binding: ActivityMostExpensiveHQBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMostExpensiveHQBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.mostExpensiveComic.observe(this, { binding.comic = it })
    }
}