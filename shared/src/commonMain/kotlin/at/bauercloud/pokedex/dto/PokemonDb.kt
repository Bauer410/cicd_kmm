package at.bauercloud.pokedex.dto

import at.bauercloud.pokedex.model.Pokemon
fun Pokemon.toDbModel() = atbauercloud.Pokemon(
    id = id.toLong(),
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

fun atbauercloud.Pokemon.toModel() = Pokemon(
    id = id.toInt(),
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