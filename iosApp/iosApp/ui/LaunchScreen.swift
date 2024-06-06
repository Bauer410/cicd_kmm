//
//  Launchscreen.swift
//  iosApp
//
//  Created by Sascha on 13.05.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LaunchScreen: View {
    @State private var showPlayMainScreen = false
    @State private var showTestMainScreen = false
    
    var body: some View {
        
        Button("Play") {
            showPlayMainScreen.toggle()
        }
        .foregroundColor(.white)
        .frame(width: 240, height: 60)
        .background(Color(.gray))
        .clipShape(Capsule())
        .padding(.vertical, 20)
        .fullScreenCover(isPresented: $showPlayMainScreen) {
            PlayMainScreen()
                .frame(maxWidth: .infinity,
                       maxHeight: .infinity)
                .ignoresSafeArea(edges: .all)
        }

        Button("Test") {
            showTestMainScreen.toggle()
        }
        .foregroundColor(.white)
        .frame(width: 240, height: 60)
        .background(Color(.gray))
        .clipShape(Capsule())
        .padding(.vertical, 20)
        .fullScreenCover(isPresented: $showTestMainScreen) {
            TestMainScreen()
                .frame(maxWidth: .infinity,
                       maxHeight: .infinity)
                .ignoresSafeArea(edges: .all)
        }
        
    }
}
