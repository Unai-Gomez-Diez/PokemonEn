package edu.iesam.pokemon.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemonById(pokemonId)
    }
}