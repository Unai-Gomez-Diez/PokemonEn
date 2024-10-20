package edu.iesam.pokemon.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.pokemon.app.domain.ErrorApp
import edu.iesam.pokemon.features.domain.GetPokemonsUseCase
import edu.iesam.pokemon.features.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
):ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun viewCreated(){
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            val pokemons = getPokemonsUseCase.invoke()
            _uiState.postValue(UiState(pokemon = pokemons))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemon : List<Pokemon>? = null
    )
}