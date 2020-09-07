package com.mutaquiha.marvel.ui.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.databinding.CharacterLoadStateFooterViewItemBinding

class CharacterLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<CharacterLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: CharacterLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CharacterLoadStateViewHolder {
        return CharacterLoadStateViewHolder.create(parent, retry)
    }
}

class CharacterLoadStateViewHolder(
    private val binding: CharacterLoadStateFooterViewItemBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState !is LoadState.Loading
        binding.errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CharacterLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.character_load_state_footer_view_item, parent, false)
            val binding = CharacterLoadStateFooterViewItemBinding.bind(view)

            return CharacterLoadStateViewHolder(binding = binding, retry = retry)
        }
    }
}