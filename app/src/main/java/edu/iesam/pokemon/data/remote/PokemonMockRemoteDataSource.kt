package edu.iesam.pokemon.data.remote

import edu.iesam.pokemon.domain.Pokemon
import edu.iesam.pokemon.domain.PokemonRepository
import edu.iesam.pokemon.domain.Sprites

class PokemonMockRemoteDataSource: PokemonRepository {

    private val pokemons = listOf(
        Pokemon("Pikachu", 25, 4, 60, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png")),
        Pokemon("Charmander", 4, 6, 85, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png")),
        Pokemon("Bulbasaur", 1, 7, 69, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"))
    )

    override fun getPokemons(): List<Pokemon> {
        return pokemons
    }

    override fun getPokemonById(pokemonId: String): Pokemon? {
        return pokemons.firstOrNull{ pokemon ->
            pokemon.name == pokemonId
        }
    }


}