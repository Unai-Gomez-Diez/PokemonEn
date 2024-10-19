package edu.iesam.pokemon.features.domain

interface PokemonRepository {
     fun getPokemons(): List<Pokemon>
     fun getPokemonById(pokemonId: String): Pokemon?
}