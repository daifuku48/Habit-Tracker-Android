package com.danilincorporated.habit_tracker_android.navigation.featureRoutes

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.danilincorporated.habit_tracker_android.SignInScreen
import com.danilincorporated.habit_tracker_android.navigation.screens.Screens

internal fun EntryProviderBuilder<Screens>.authRoute(backStack: SnapshotStateList<Screens>) {
    entry<Screens.SignIn> {
        SignInScreen()
    }
}
