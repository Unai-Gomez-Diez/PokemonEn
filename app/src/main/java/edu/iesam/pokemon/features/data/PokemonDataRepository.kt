package edu.iesam.pokemon.features.data

import edu.iesam.pokemon.features.data.local.PokemonXmlLocalDataSource
import edu.iesam.pokemon.features.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokemon.features.domain.Pokemon
import edu.iesam.pokemon.features.domain.PokemonRepository

class PokemonDataRepository(
    private val local : PokemonXmlLocalDataSource,
    private val mock: PokemonMockRemoteDataSource
): PokemonRepository {


     override fun getPokemons(): List<Pokemon> {
        val pokemonFromLocal = local.findAll()
        if (pokemonFromLocal.isEmpty()) {
            val pokemonFromRemote = mock.getPokemons()
            local.saveAll(pokemonFromRemote)
            return pokemonFromRemote
        }else{
            return pokemonFromLocal
        }
    }

     override fun getPokemonById(pokemonId: String): Pokemon? {
        val localPokemon = local.findById(pokemonId)
        if (localPokemon == null) {
            mock.getPokemonById(pokemonId)?.let { pokemon ->
                local.save(pokemon)
                return pokemon
            }
        }
        return localPokemon
    }
}