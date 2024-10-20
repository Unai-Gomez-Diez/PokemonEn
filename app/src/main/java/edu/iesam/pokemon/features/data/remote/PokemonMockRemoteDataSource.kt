package edu.iesam.pokemon.features.data.remote

import android.util.Log
import edu.iesam.pokemon.features.domain.Pokemon
import edu.iesam.pokemon.features.domain.PokemonRepository

class PokemonMockRemoteDataSource: PokemonRepository {

    private val pokemons = listOf(
        Pokemon(
            id = "1",
            name = "Bulbasaur",
            height = 7,
            weight = 69
        ),
        Pokemon(
            id = "2",
            name = "Ivysaur",
            height = 1,
            weight = 13
        ),
        Pokemon(
            id = "3",
            name = "Venusaur",
            height = 2,
            weight = 100
        )
    )

    override fun getPokemons(): List<Pokemon> {
        return pokemons
    }

    override fun getPokemonById(pokemonId: String): Pokemon? {
        return pokemons.firstOrNull { pokemon ->
            pokemon.id == pokemonId
        }
    }



}