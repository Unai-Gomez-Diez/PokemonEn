package edu.iesam.pokemon.features.presentation

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.pokemon.databinding.ViewPokemonItemBinding
import edu.iesam.pokemon.features.domain.Pokemon

class PokemonViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private val binding: ViewPokemonItemBinding = ViewPokemonItemBinding.bind(view)

    fun bind(model: Pokemon) {
        binding.apply {
            pokemonId.text = model.id
            pokemonNombre.text = model.name
           pokemonId.setOnClickListener {
                navigateToDetails(model.id)
            }
        }
    }

    private fun navigateToDetails(pokemonId: String) {
        findNavController(view).navigate(
            PokemonFragmentDirections.actionFragmentPokemonToFragmentPokemonDetail(pokemonId)
        )
    }
}
