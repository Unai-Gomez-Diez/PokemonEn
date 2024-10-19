package edu.iesam.pokemon.features.domain

data class Pokemon(
    val name: String,
    val id: Int,
    val height: Int,
    val weight: Int,
    val sprites: Sprites
)

data class Sprites(
    val front_default: String
)

