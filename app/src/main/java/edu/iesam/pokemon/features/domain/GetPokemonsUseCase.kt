package edu.iesam.pokemon.features.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun execute(): List<Pokemon> {
        return pokemonRepository.getPokemons()
    }
}