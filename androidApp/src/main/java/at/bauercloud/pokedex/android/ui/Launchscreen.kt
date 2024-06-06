package at.bauercloud.pokedex.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import at.bauercloud.pokedex.Greeting
import at.bauercloud.pokedex.Platform
import at.bauercloud.pokedex.android.helper.NavigationItem
import at.bauercloud.pokedex.model.Pokemon

@Composable
fun LaunchScreen(
    navController: NavHostController
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GreetingView(Greeting(Platform()).greet())

        Spacer(modifier = Modifier.height(30.dp))

        FilledButton("Play") {
            navController.navigate(NavigationItem.PlayMain.route)
        }

        Spacer(modifier = Modifier.height(30.dp))

        FilledButton("Test") {
            navController.navigate(NavigationItem.TestMain.route)
        }
    }

}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable
fun FilledButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(200.dp)
            .height(60.dp),

        ) {
        Text(text)
    }
}


