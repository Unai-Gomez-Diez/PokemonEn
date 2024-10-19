package edu.iesam.pokemon.features.presentation

import android.content.Context
import edu.iesam.pokemon.features.data.PokemonDataRepository
import edu.iesam.pokemon.features.data.local.PokemonXmlLocalDataSource
import edu.iesam.pokemon.features.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokemon.features.domain.GetPokemonUseCase
import edu.iesam.pokemon.features.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {
    private val pokemonMock = PokemonMockRemoteDataSource()
    private val pokemonLocal = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository = PokemonDataRepository(pokemonLocal, pokemonMock)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)


    fun buildViewModel(): PokemonViewModel{
        return PokemonViewModel(getPokemonsUseCase)
    }

    /*
    fun buildPokemonDetailViewModel(): PokemonDetailViewModel{
        return PokemonDetailViewModel(getPokemonUseCase)
    }
     */
}