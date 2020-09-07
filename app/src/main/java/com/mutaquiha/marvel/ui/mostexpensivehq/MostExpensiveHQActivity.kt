package com.mutaquiha.marvel.ui.mostexpensivehq

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.ui.mostexpensivehq.viewmodel.MostExpensiveHQViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostExpensiveHQActivity : AppCompatActivity() {

    private val viewModel: MostExpensiveHQViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_expensive_h_q)
    }
}