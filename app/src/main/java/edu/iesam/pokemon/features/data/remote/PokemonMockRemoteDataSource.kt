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
        ),
        Pokemon(
            id = "4",
            name = "Charmander",
            height = 6,
            weight = 85
        ),
        Pokemon(
            id = "5",
            name = "Charmeleon",
            height = 11,
            weight = 190
        ),
        Pokemon(
            id = "6",
            name = "Charizard",
            height = 17,
            weight = 905
        ),
        Pokemon(
            id = "7",
            name = "Squirtle",
            height = 5,
            weight = 90
        ),
        Pokemon(
            id = "8",
            name = "Wartortle",
            height = 10,
            weight = 225
        ),
        Pokemon(
            id = "9",
            name = "Blastoise",
            height = 16,
            weight = 855
        ),
        Pokemon(
            id = "10",
            name = "Caterpie",
            height = 3,
            weight = 29
        ),
        Pokemon(
            id = "11",
            name = "Metapod",
            height = 7,
            weight = 99
        ),
        Pokemon(
            id = "12",
            name = "Butterfree",
            height = 11,
            weight = 320
        ),
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