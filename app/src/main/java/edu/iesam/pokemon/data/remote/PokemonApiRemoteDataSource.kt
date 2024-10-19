package edu.iesam.pokemon.data.remote

import edu.iesam.pokemon.domain.Pokemon
import edu.iesam.pokemon.domain.PokemonRepository

class PokemonApiRemoteDataSource: PokemonRepository {


    override fun getPokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun getPokemonById(pokemonId: String): Pokemon? {
        TODO("Not yet implemented")
    }
}