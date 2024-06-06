package at.bauercloud.pokedex.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import at.bauercloud.pokedex.KMPPokemon
import at.bauercloud.pokedex.di.initKoin
import org.koin.android.ext.android.inject
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    private val kmpPokemon: KMPPokemon by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin(
            module {
                single<Context> { this@MainActivity }
            }
        )

        // Set Up Pokemon DB for first use
        kmpPokemon.insertExamplePokemons()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(kmpPokemon, navController = rememberNavController())
                }
            }
        }
    }
}
