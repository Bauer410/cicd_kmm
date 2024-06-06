package at.bauercloud.pokedex.android.helper

enum class PokedexNavScreen {
    Launchscreen,
    PlayMain,
    PlayPokemonFangen,
    PlayDetails,
    TestMain
}

sealed class NavigationItem(val route: String) {
    object Launchscreen : NavigationItem(PokedexNavScreen.Launchscreen.name)
    object PlayMain : NavigationItem(PokedexNavScreen.PlayMain.name)
    object PlayPokemonFangen : NavigationItem(PokedexNavScreen.PlayPokemonFangen.name)
    object PlayDetails : NavigationItem(PokedexNavScreen.PlayDetails.name)
    object TestMain : NavigationItem(PokedexNavScreen.TestMain.name)
}

