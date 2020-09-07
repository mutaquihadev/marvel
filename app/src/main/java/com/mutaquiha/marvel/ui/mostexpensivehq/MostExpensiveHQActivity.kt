package com.mutaquiha.marvel.ui.mostexpensivehq

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mutaquiha.marvel.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostExpensiveHQActivity : AppCompatActivity() {

    private val viewModel: MostExpensiveHQViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_expensive_h_q)

        viewModel.pages.observe(this, {
            Toast.makeText(this, "There are $it pages ", Toast.LENGTH_SHORT).show()
        })
    }
}