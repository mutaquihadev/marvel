package com.mutaquiha.marvel.ui.characterlist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mutaquiha.marvel.commons.Constants.KEY_CHARACTER
import com.mutaquiha.marvel.databinding.ActivityCharactersListBinding
import com.mutaquiha.marvel.domain.entity.Character
import com.mutaquiha.marvel.ui.CharacterDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private val viewModel: CharactersListViewModel by viewModels()
    private lateinit var binding: ActivityCharactersListBinding

    private val adapter by lazy {
        CharactersAdapter(CharacterClickListener(this::openCharacterDetails))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()

        collectCharacters()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = adapter
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