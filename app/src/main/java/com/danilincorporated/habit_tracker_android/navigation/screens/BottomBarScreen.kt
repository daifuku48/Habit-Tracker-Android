package com.danilincorporated.habit_tracker_android.navigation.screens

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

val bottomBarItems = persistentListOf(
    BottomBarScreen.Home,
    BottomBarScreen.CalendarStats,
    BottomBarScreen.Articles,
    BottomBarScreen.Profile,
)

enum class BottomIcon {
    HOME,
    CALENDAR,
    ARTICLES,
    PROFILE,
}

@Serializable
sealed class BottomBarScreen(
    val icon: BottomIcon,
    val contentDescription: String,
) : NavKey {
    @Serializable
    data object Home : BottomBarScreen(BottomIcon.HOME, "Home Screen")

    @Serializable
    data object CalendarStats : BottomBarScreen(BottomIcon.CALENDAR, "Calendar Screen")

    @Serializable
    data object Articles : BottomBarScreen(BottomIcon.ARTICLES, "Articles Screen")

    @Serializable
    data object Profile : BottomBarScreen(BottomIcon.PROFILE, "Profile Screen")
}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.java.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Profile::class.simpleName -> BottomBarScreen.Profile
            BottomBarScreen.Articles::class.simpleName -> BottomBarScreen.Articles
            BottomBarScreen.CalendarStats::class.simpleName -> BottomBarScreen.CalendarStats
            else -> BottomBarScreen.Home
        }
    }
)