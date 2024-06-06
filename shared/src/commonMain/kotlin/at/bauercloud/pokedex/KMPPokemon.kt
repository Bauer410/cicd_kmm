package at.bauercloud.pokedex

import at.bauercloud.pokedex.database.PokemonDbImpl
import at.bauercloud.pokedex.model.Pokemon

class KMPPokemon(
    private val db: PokemonDbImpl
) {

    fun insertExamplePokemons() {
        val ditto = Pokemon(132, "ditto")
        val mew = Pokemon(248, "mew")
        val pikachu = Pokemon(35, "pikachu")
        val onix = Pokemon(151, "onix")
        val zubat = Pokemon(73, "zubat")

        db.insertPokemon(ditto)
        db.insertPokemon(mew)
        db.insertPokemon(pikachu)
        db.insertPokemon(onix)
        db.insertPokemon(zubat)
    }

    fun getAllPokemonFromDb(): List<Pokemon> {
        return db.readAllPokemon() ?: arrayListOf()
    }

    fun interactWithDb(): String {
        println("interactWithDb() called")
//        db.insertPokemon("ditto")
        println(db.readAllPokemon().toString())
        return "this is a return string"
    }


}


