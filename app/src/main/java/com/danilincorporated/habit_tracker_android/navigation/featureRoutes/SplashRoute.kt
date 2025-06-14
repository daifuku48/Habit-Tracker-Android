package com.danilincorporated.habit_tracker_android.navigation.featureRoutes

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.danilincorporated.habit_tracker_android.navigation.screens.Screens
import com.danilincorporated.splash.SplashScreen

internal fun EntryProviderBuilder<Screens>.splashRoutes(backStack: SnapshotStateList<Screens>) {
    entry<Screens.Splash> {
        SplashScreen(
            onNextScreen = {
                backStack.add(Screens.NestedGraph)
            }
        )
    }
}