package at.bauercloud.pokedex.database

import app.cash.sqldelight.db.SqlDriver
import at.bauercloud.Database
import at.bauercloud.pokedex.dto.toDbModel
import at.bauercloud.pokedex.dto.toModel
import at.bauercloud.pokedex.model.Pokemon

class PokemonDbImpl(
    sqlDriver: SqlDriver
) : PokemonDb {
    private val dbRef: Database = Database(sqlDriver)

    override fun insertPokemon(pokemon: Pokemon) {
        try {
            dbRef.pokemonQueries.insert(pokemon.toDbModel())
        } catch (e: Exception) {
            println("Database Error" + e.message)
        }
    }

    override fun readPokemon(id: Int): Pokemon? {
        try {
            return dbRef.pokemonQueries.find(id.toLong()).executeAsOne().toModel()
        } catch (e: Exception) {
            println("Database Error" + e.message)
        }
        return null
    }

    override fun readAllPokemon(): List<Pokemon>? {
        try {
            val pokemonList = dbRef.pokemonQueries.selectAll().executeAsList()
            return pokemonList.map {
                it.toModel()
            }
        } catch (e: Exception) {
            println("Database Error" + e.message)
        }
        return null
    }

    override fun deletePokemon(id: Int) {
        try {
            dbRef.pokemonQueries.delete(id.toLong())
        } catch (e: Exception) {
            println("Database Error" + e.message)
        }
    }
}