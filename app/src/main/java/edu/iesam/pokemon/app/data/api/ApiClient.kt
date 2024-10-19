package edu.iesam.pokemon.app.data.api

import edu.iesam.pokemon.features.data.remote.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Companion.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providePokemonService(): PokemonService {
        return provideRetrofit().create(PokemonService::class.java)
    }

    companion object {
        private const val BASE_URL_API = "https://pokeapi.co/api/v2/"
    }
}