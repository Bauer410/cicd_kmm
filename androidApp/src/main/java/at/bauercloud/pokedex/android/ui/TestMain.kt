package at.bauercloud.pokedex.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import at.bauercloud.pokedex.KMPPokemon

@Composable
fun TestMainScreen(
    kmpPokemon: KMPPokemon,
    navController: NavHostController
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is the TestMainScreen")
    }

}