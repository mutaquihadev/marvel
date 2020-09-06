package com.mutaquiha.marvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mutaquiha.marvel.R
import com.mutaquiha.marvel.data.MarvelApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class CharactersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        CoroutineScope(Main).launch {
            val stringBuilder = StringBuilder()
            MarvelApi.getService().getCharacters().data.results.forEach {
                    stringBuilder.append("${it.name}\n")
            }
            Toast.makeText(this@CharactersListActivity, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}