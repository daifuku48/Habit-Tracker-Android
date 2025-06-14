package com.danilincorporated.habit_tracker_android.navigation.screens

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface Screens : NavKey {

    @Serializable
    data object Splash : Screens

    @Serializable
    data object SignIn : Screens

    @Serializable
    data object NestedGraph : Screens
}