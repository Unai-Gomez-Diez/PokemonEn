package edu.iesam.pokemon.features.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.pokemon.databinding.FragmentPokemonBinding
import edu.iesam.pokemon.app.domain.ErrorApp
import edu.iesam.pokemon.features.domain.Pokemon

class PokemonFragment: Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel  : PokemonViewModel

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildViewModel()
        SetupObserver()
        viewModel.viewCreated()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun SetupObserver() {
        val pokemonObserver = Observer<PokemonViewModel.UiState>{ state ->
            state.pokemon?.let{
                bindData(it)
            }
            state.errorApp?.let{
                showError(it)
            }
            if(state.isLoading){
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev", " Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)
    }

    private fun bindData(pokemons: List<Pokemon>) {
        binding.apply {
            id.text = pokemons[0].id.toString()
            nombre.text = pokemons[0].name

            id3.text = pokemons[0].id.toString()
            nombre.text = pokemons[0].name

            id3.text = pokemons[0].id.toString()
            nombre3.text = pokemons[0].name

        }
    }

    private fun showError(error: ErrorApp){
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    /*
    fun navigateToPokemonDetail(pokemonId: String) {
        findNavController().navigate(
            PokemonFragmentDirections.actionMovieFragmentToMovieDetailFragment
                (pokemonId)
        )    }

     */


    override fun onDestroyView() {
        // Limpiar el enlace de vista cuando se destruye la vista
        super.onDestroyView()
        _binding = null
    }
}
