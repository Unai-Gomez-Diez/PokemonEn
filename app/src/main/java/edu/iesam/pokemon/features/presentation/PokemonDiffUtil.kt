package edu.iesam.pokemon.features.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.pokemon.features.domain.Pokemon

class PokemonDiffUtil: DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

}