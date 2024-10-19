package edu.iesam.pokemon.data

import edu.iesam.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.pokemon.data.remote.PokemonApiRemoteDataSource
import edu.iesam.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokemon.domain.Pokemon
import edu.iesam.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val local : PokemonXmlLocalDataSource,
    private val remote : PokemonApiRemoteDataSource,
    private val mock: PokemonMockRemoteDataSource
): PokemonRepository {


    override fun getPokemons(): List<Pokemon> {
        return mock.getPokemons()
    }

    override fun getPokemonById(pokemonId: String): Pokemon? {
        return mock.getPokemonById(pokemonId)
    }
}