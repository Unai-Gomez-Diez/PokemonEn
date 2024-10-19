package edu.iesam.pokemon.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val imageUrl: String
)
