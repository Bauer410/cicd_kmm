//
//  PlayDetailsScreen.swift
//  iosApp
//
//  Created by Sascha on 13.05.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PlayDetailsScreen: View {
    let pokemon: Pokemon
    
    var body: some View {
        Text("Detail Screen Pokemon")
        Text(pokemon.name)
        Text(pokemon.id.description)
    }
}
