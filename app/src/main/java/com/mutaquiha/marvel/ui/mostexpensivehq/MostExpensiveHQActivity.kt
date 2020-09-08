package com.mutaquiha.marvel.ui.mostexpensivehq

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.mutaquiha.marvel.commons.ImageSize
import com.mutaquiha.marvel.commons.extensions.getImageUrl
import com.mutaquiha.marvel.commons.extensions.load
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