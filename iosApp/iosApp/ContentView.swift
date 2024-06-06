import SwiftUI
import shared

struct ContentView: View {
    let kmpPokemon = KMPPokemonHelper().getKmpPokemon()
    
    var body: some View {
        NavigationStack {
            LaunchScreen()
                .navigationTitle("Pokedex")
                .navigationBarTitleDisplayMode(.large)
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
