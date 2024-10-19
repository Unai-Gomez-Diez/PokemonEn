package edu.iesam.pokemon.features.data.remote

import edu.iesam.pokemon.features.domain.Pokemon
import edu.iesam.pokemon.features.domain.PokemonRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonApiRemoteDataSource(private val pokemonService: PokemonService): PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        val response = pokemonService.getAllPokemons()
        return response.results.map { result ->
            val pokemonDetails = pokemonService.getPokemonById(result.name)
            pokemonDetails
        }
    }

    override suspend fun getPokemonById(pokemonId: String): Pokemon? {
        return pokemonService.getPokemonById(pokemonId)
    }
}
