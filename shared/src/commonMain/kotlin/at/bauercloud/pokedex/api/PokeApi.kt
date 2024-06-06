package at.bauercloud.pokedex.api

import at.bauercloud.pokedex.model.Pokemon

interface PokeApi {

    suspend fun getPokemonWithName(name: String): Pokemon
}