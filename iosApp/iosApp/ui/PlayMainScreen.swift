//
//  PlayMain.swift
//  iosApp
//
//  Created by Sascha on 13.05.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PlayMainScreen: View {
    let kmpPokemon = KMPPokemonHelper().getKmpPokemon()
    
    
    var body: some View {
        NavigationStack {
            let pokemonList = kmpPokemon.getAllPokemonFromDb()
            
            List(pokemonList, id: \.self) { pokemon in
                NavigationLink(destination: PlayDetailsScreen(pokemon: pokemon)) {
                    Text(pokemon.name)
                }
                
            }
            .navigationTitle("Pokedex")
        }
    }
    
}
