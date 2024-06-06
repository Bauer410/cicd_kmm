package at.bauercloud.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
//    val baseExperience: Int? = null,
//    val height: Int,
//    val isDefault: Boolean? = null,
//    val order: Int,
//    val weight: Int,
//    val species: NamedApiResource,
//    val abilities: List<PokemonAbility>,
//    val forms: List<NamedApiResource>,
//    val gameIndices: List<VersionGameIndex>,
//    val heldItems: List<PokemonHeldItem>,
//    val moves: List<PokemonMove>,
//    val stats: List<PokemonStat>? = null,
//    val types: List<PokemonType>? = null,
//    val sprites: PokemonSprites? = null
)

@Serializable
data class PokemonStat(
    val stat: String,
    val effort: Int,
    val baseStat: Int
)

@Serializable
data class PokemonType(
    val slot: Int,
    val type: String
)

@Serializable
data class PokemonSprites(
    val backDefault: String? = null,
    val backShiny: String? = null,
    val frontDefault: String? = null,
    val frontShiny: String? = null,
    val backFemale: String? = null,
    val backShinyFemale: String? = null,
    val frontFemale: String? = null,
    val frontShinyFemale: String? = null
)