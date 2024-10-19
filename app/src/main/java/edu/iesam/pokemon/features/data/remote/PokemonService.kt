package edu.iesam.pokemon.features.data.remote

import edu.iesam.pokemon.features.domain.Pokemon
import edu.iesam.pokemon.features.domain.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("/pokemon")
    suspend fun getAllPokemons(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") pokemonId: String): Pokemon
}