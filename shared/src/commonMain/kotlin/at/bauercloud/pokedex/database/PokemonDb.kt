package at.bauercloud.pokedex.database

import at.bauercloud.pokedex.model.Pokemon

interface PokemonDb {
    fun insertPokemon(pokemon: Pokemon)
    fun readPokemon(id: Int): Pokemon?
    fun readAllPokemon(): List<Pokemon>?
    fun deletePokemon(id: Int)

}