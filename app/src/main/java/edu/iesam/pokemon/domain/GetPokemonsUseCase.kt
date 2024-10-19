package edu.iesam.pokemon.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    fun execute(): List<Pokemon> {
        return pokemonRepository.getPokemons()
    }
}