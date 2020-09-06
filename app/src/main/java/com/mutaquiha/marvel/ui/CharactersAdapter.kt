package com.mutaquiha.marvel.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.commons.extensions.getImageUrl
import com.mutaquiha.marvel.commons.extensions.load


class CharactersAdapter :
    PagingDataAdapter<com.mutaquiha.marvel.domain.entity.Character, CharactersAdapter.CharacterHolder>(
        CharacterDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_character, parent, false)
        return CharacterHolder(view)
    }

    class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imCharacterImage)
        val name: TextView = itemView.findViewById(R.id.tvCharacterName)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = getItem(position)
        character?.let {
            holder.name.text = character.name
            holder.imageView.load(character.getImageUrl())
        }
    }
}

class CharacterDiffCallback :
    DiffUtil.ItemCallback<com.mutaquiha.marvel.domain.entity.Character>() {
    override fun areItemsTheSame(
        old: com.mutaquiha.marvel.domain.entity.Character,
        aNew: com.mutaquiha.marvel.domain.entity.Character
    ): Boolean {
        return old.id == aNew.id
    }

    override fun areContentsTheSame(
        old: com.mutaquiha.marvel.domain.entity.Character,
        aNew: com.mutaquiha.marvel.domain.entity.Character
    ): Boolean {
        return old == aNew
    }
}
