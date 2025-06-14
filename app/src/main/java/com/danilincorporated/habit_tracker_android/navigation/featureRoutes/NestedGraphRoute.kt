package com.danilincorporated.habit_tracker_android.navigation.featureRoutes

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.danilincorporated.habit_tracker_android.navigation.nestedScreen.NestedScreen
import com.danilincorporated.habit_tracker_android.navigation.screens.Screens

internal fun EntryProviderBuilder<Screens>.nestedGraphRoutes(backStack: SnapshotStateList<Screens>) {
    entry<Screens.NestedGraph> {
        NestedScreen(

        )
    }
}