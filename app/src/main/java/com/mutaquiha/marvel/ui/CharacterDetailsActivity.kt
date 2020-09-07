package com.mutaquiha.marvel.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.commons.Constants.KEY_CHARACTER
import com.mutaquiha.marvel.commons.ImageSize
import com.mutaquiha.marvel.commons.extensions.getImageUrl
import com.mutaquiha.marvel.commons.extensions.load
import com.mutaquiha.marvel.domain.entity.Character
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetailsActivity : AppCompatActivity() {

    private val imCharacter by lazy {
        findViewById<ImageView>(R.id.imCharacterImage)
    }

    private val tvName by lazy {
        findViewById<TextView>(R.id.tvName)
    }

    private val tvMostExpensiveHQ by lazy {
        findViewById<TextView>(R.id.tvMostExpensiveHQ)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getSerializableExtra(KEY_CHARACTER) as Character?

        character?.let { handleSuccess(it) } ?: run { handleError() }
    }

    private fun handleSuccess(character: Character) {
        imCharacter.load(character.getImageUrl(ImageSize.LANDSCAPE_LARGE))
        tvName.text = character.name
        character.description.isNotEmpty().let {isNotEmpty ->
            if(isNotEmpty) {
                tvDescription.visibility = View.VISIBLE
                tvDescription.text = character.description
            }
        }

        if(character.availableComicsCount > 0) {
            tvMostExpensiveHQ.isEnabled = true
            tvMostExpensiveHQ.text = getString(R.string.see_most_expensive_hq)
        } else {
            tvMostExpensiveHQ.isEnabled = false
            tvMostExpensiveHQ.text = getString(R.string.hq_unavailable)
        }
    }

    private fun handleError() {
        Toast.makeText(
            this,
            R.string.error_while_opening_character_details,
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }
}