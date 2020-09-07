package com.mutaquiha.marvel.ui.characterlist

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
import com.mutaquiha.marvel.domain.entity.Character


class CharactersAdapter(private val clickListener: CharacterClickListener) :
    PagingDataAdapter<Character, CharactersAdapter.CharacterHolder>(
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
        val availableComicsCount: TextView = itemView.findViewById(R.id.tvAvailableComicsCount)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = getItem(position)
        character?.let {
            holder.itemView.setOnClickListener {clickListener.onClick(character)}
            holder.name.text = character.name
            holder.imageView.load(character.getImageUrl())
            holder.availableComicsCount.text = "${character.availableComicsCount}"
        }
    }
}

class CharacterDiffCallback :
    DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(
        old: Character,
        aNew: Character
    ): Boolean {
        return old.id == aNew.id
    }

    override fun areContentsTheSame(
        old: Character,
        aNew: Character
    ): Boolean {
        return old == aNew
    }
}

class CharacterClickListener(val clickListener: (character: Character) -> Unit) {
    fun onClick(character: Character) = clickListener(character)
}