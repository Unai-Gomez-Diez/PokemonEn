package edu.iesam.pokemon.domain

interface PokemonRepository {
    fun getPokemons(): List<Pokemon>
    fun getPokemonById(pokemonId: String): Pokemon?
}