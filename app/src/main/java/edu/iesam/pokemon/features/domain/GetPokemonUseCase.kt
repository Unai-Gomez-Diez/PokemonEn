package edu.iesam.pokemon.features.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemonById(pokemonId)
    }
}