package edu.iesam.pokemon.features.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.pokemon.R
import edu.iesam.pokemon.features.domain.Pokemon

class PokemonAdapter: ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}