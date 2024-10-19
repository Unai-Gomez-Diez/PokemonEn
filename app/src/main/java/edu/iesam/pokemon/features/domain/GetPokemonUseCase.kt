package edu.iesam.pokemon.features.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemonById(pokemonId)
    }
}