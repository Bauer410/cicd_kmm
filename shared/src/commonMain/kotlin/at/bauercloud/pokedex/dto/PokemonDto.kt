package at.bauercloud.pokedex.dto

import at.bauercloud.pokedex.model.Pokemon
import at.bauercloud.pokedex.model.PokemonSprites
import at.bauercloud.pokedex.model.PokemonStat
import at.bauercloud.pokedex.model.PokemonType
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    val id: Int,
    val name: String,
//    val base_experience: Int,
//    val height: Int,
//    val is_default: Boolean,
//    val order: Int,
//    val weight: Int,
//    val species: NamedApiResource,
//    val abilities: List<PokemonAbility>,
//    val forms: List<NamedApiResource>,
//    val gameIndices: List<VersionGameIndex>,
//    val heldItems: List<PokemonHeldItem>,
//    val moves: List<PokemonMove>,
//    val stats: List<PokemonStatDto>? = null,
//    val types: List<PokemonTypeDto>? = null,
//    val sprites: PokemonSpritesDto? = null
)

@Serializable
data class PokemonStatDto(
    val stat: String,
    val effort: Int,
    val base_stat: Int
)

@Serializable
data class PokemonTypeDto(
    val slot: Int,
    val type: String
)

@Serializable
data class PokemonSpritesDto(
    val back_default: String? = null,
    val back_shiny: String? = null,
    val front_default: String? = null,
    val front_shiny: String? = null,
    val back_female: String? = null,
    val back_shiny_female: String? = null,
    val front_female: String? = null,
    val front_shiny_female: String? = null
)

fun PokemonDto.toModel() = Pokemon(
    id = id,
    name = name
//    baseExperience = base_experience,
//    height = height,
//    isDefault = is_default,
//    order = order,
//    weight = weight,
//    stats = stats?.toPokemonStatModel(),
//    types = types?.toPokemonTypeModel(),
//    sprites = sprites?.toModel()
)

fun List<PokemonStatDto>.toPokemonStatModel(): List<PokemonStat> {
    return map {
        PokemonStat(
            stat = it.stat,
            effort = it.effort,
            baseStat = it.base_stat
        )
    }
}

fun List<PokemonTypeDto>.toPokemonTypeModel(): List<PokemonType> {
    return map {
        PokemonType(
            slot = it.slot,
            type = it.type,
        )
    }
}

fun PokemonSpritesDto.toModel() = PokemonSprites(
    backDefault = back_default,
    backShiny = back_shiny,
    frontDefault = front_default,
    frontShiny = front_shiny,
    backFemale = back_female,
    backShinyFemale = back_shiny_female,
    frontFemale = front_female,
    frontShinyFemale = front_shiny_female
)
