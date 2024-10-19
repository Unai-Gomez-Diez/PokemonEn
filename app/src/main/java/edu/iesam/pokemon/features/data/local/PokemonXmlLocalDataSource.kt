package edu.iesam.pokemon.features.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.pokemon.features.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "pokemon", Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(pokemon: Pokemon) {
        val editor = sharedPref.edit()
        editor.putString(pokemon.name, gson.toJson(pokemon))
        editor.apply()
    }

    fun delete(){
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    fun saveAll(pokemons: List<Pokemon>) {
        val editor = sharedPref.edit()
        pokemons.forEach {
            editor.putString(it.name, gson.toJson(it))
        }
        editor.apply()
    }

    fun findAll(): List<Pokemon> {
        val pokemons = ArrayList<Pokemon>()
        val mapPokemon = sharedPref.all
        mapPokemon.forEach {
            pokemons.add(gson.fromJson(it.value as String, Pokemon::class.java))
        }
        return pokemons
    }

    fun deleteById(id: String) {
        val editor = sharedPref.edit()
        editor.remove(id)
        editor.apply()
    }
}