package edu.iesam.pokemon.features.domain

interface PokemonRepository {
    suspend fun getPokemons(): List<Pokemon>
    suspend fun getPokemonById(pokemonId: String): Pokemon?
}