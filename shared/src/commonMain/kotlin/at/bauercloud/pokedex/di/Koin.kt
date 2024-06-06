package at.bauercloud.pokedex.di

import at.bauercloud.pokedex.KMPPokemon
import at.bauercloud.pokedex.api.PokeApiImpl
import at.bauercloud.pokedex.database.PokemonDbImpl
import at.bauercloud.pokedex.httpClient.PokeDexApi
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule
        )
    }
    return koinApplication
}

private val coreModule = module {
    single { PokemonDbImpl(get()) }
    single { KMPPokemon(get()) }
    single { PokeDexApi() }
    single { PokeApiImpl(get()) }
}

