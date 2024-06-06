package at.bauercloud.pokedex

import at.bauercloud.pokedex.di.initKoin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module

class KMPPokemonHelper : KoinComponent {
    private val kmpPokemon: KMPPokemon by inject()

    fun getKmpPokemon(): KMPPokemon {
        return kmpPokemon
    }
}

fun initKoinIos() {
    initKoin(
        module { }
    )
}