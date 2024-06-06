package at.bauercloud.pokedex.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import at.bauercloud.pokedex.KMPPokemon
import at.bauercloud.pokedex.android.helper.NavigationItem
import at.bauercloud.pokedex.model.Pokemon

@Composable
fun PlayMainScreen(
    kmpPokemon: KMPPokemon,
    navController: NavHostController
) {
    val pokemonList = kmpPokemon.getAllPokemonFromDb()

    PokemonMainView(pokemons = pokemonList, navController = navController)
}


@Composable
fun PokemonMainView(
    pokemons: List<Pokemon>,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon = pokemon) {
                navController.navigate(NavigationItem.TestMain.route)
            }
        }
    }
}

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onIconClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
              onIconClick()
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontSize = 20.sp
            )
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_share),
                contentDescription = "Clickable Icon",
                modifier = Modifier
                    .clickable {
                        onIconClick()
                    }
                    .size(30.dp)
            )
        }
    }
}