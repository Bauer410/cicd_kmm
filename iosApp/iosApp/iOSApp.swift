import SwiftUI
import shared

@main
struct iOSApp: App {
    
    // KMM - Koin Call
        init() {
            HelperKt.doInitKoinIos()
            initDB()
        }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}

func initDB() {
    let kmpPokemonIn = KMPPokemonHelper().getKmpPokemon()
    kmpPokemonIn.insertExamplePokemons()
}
