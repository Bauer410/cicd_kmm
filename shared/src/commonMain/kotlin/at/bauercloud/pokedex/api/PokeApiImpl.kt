package at.bauercloud.pokedex.api

import at.bauercloud.pokedex.dto.PokemonDto
import at.bauercloud.pokedex.dto.toModel
import at.bauercloud.pokedex.httpClient.PokeDexApi
import at.bauercloud.pokedex.model.Pokemon
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class PokeApiImpl(
    private val apiClientClass: PokeDexApi
) : PokeApi {
    private val pokedexUrl = "https://pokeapi.co/api/v2/pokemon/"
    private val apiClient = apiClientClass.getApiClient()

    override suspend fun getPokemonWithName(name: String): Pokemon {
        val response = apiClient.get(pokedexUrl + name)
        return response.body<PokemonDto>().toModel()
    }

}