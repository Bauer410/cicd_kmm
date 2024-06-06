package at.bauercloud.pokedex.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import at.bauercloud.pokedex.KMPPokemon
import at.bauercloud.pokedex.android.ui.LaunchScreen
import at.bauercloud.pokedex.android.helper.NavigationItem
import at.bauercloud.pokedex.android.ui.PlayMainScreen
import at.bauercloud.pokedex.android.helper.PokedexNavScreen
import at.bauercloud.pokedex.android.ui.TestMainScreen

@Composable
fun AppNavHost(
    kmpPokemon: KMPPokemon,
    navController: NavHostController,
    startDestination: String = NavigationItem.Launchscreen.route,
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PokedexNavScreen.valueOf(
        backStackEntry?.destination?.route ?: PokedexNavScreen.Launchscreen.name
    )

    Scaffold(
        topBar = {
            PokemonAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavigationItem.Launchscreen.route) {
                LaunchScreen(
                    navController = navController
                )
            }
            composable(NavigationItem.PlayMain.route) {
                PlayMainScreen(
                    kmpPokemon = kmpPokemon,
                    navController = navController
                )
            }
            composable(NavigationItem.TestMain.route) {
                TestMainScreen(
                    kmpPokemon = kmpPokemon,
                    navController = navController
                )
            }
        }
    }
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonAppBar(
    currentScreen: PokedexNavScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = { Text("Pokedex") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}