package edu.iesam.pokemon.features.data

import edu.iesam.pokemon.features.data.local.PokemonXmlLocalDataSource
import edu.iesam.pokemon.features.data.remote.PokemonApiRemoteDataSource
import edu.iesam.pokemon.features.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokemon.features.domain.Pokemon
import edu.iesam.pokemon.features.domain.PokemonRepository

class PokemonDataRepository(
    private val local : PokemonXmlLocalDataSource,
    private val remote : PokemonApiRemoteDataSource,
    private val mock: PokemonMockRemoteDataSource
): PokemonRepository {


    suspend override fun getPokemons(): List<Pokemon> {
        return mock.getPokemons()
    }

    suspend override fun getPokemonById(pokemonId: String): Pokemon? {
        return mock.getPokemonById(pokemonId)
    }
}