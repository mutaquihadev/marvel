package com.mutaquiha.marvel.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.commons.Constants.KEY_CHARACTER
import com.mutaquiha.marvel.domain.entity.Character
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private val viewModel: CharactersListViewModel by viewModels()

    private val adapter by lazy {
        CharactersAdapter(CharacterClickListener(this::openCharacterDetails))
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        recyclerView.adapter = adapter

        collectCharacters()
    }

    private fun collectCharacters() {
        lifecycleScope.launch {
            viewModel.getCharacters().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun openCharacterDetails(character: Character) {
        val intent = Intent(this, CharacterDetailsActivity::class.java)
        intent.putExtra(KEY_CHARACTER, character)
        startActivity(intent)
    }
}