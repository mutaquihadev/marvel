package com.mutaquiha.marvel.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.domain.NetworkViewState
import com.mutaquiha.marvel.domain.entity.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private val viewModel: CharactersListViewModel by viewModels()

    private val adapter by lazy {
        CharactersAdapter()
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        recyclerView.adapter = adapter

        viewModel.viewState.observe(this, this::handleViewState)

        viewModel.getCharacters()
    }

    private fun handleViewState(viewState: NetworkViewState<List<Character>>) = when (viewState) {
        is NetworkViewState.Success -> adapter.submitList(viewState.result)
        is NetworkViewState.Error -> Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        is NetworkViewState.Loading -> Toast.makeText(this, "handle loading", Toast.LENGTH_SHORT)
            .show()
    }
}