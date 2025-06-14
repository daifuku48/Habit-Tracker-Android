package com.danilincorporated.habit_tracker_android.navigation.nestedScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.danilincorporated.habit_tracker_android.SignInScreen
import com.danilincorporated.habit_tracker_android.navigation.navigationBottomBar.HabitTrackerBottomBar
import com.danilincorporated.habit_tracker_android.navigation.screens.BottomBarScreen
import com.danilincorporated.habit_tracker_android.navigation.screens.BottomBarScreenSaver
import com.danilincorporated.habit_tracker_android.navigation.screens.bottomBarItems
import com.danilincorporated.splash.SplashScreen

@Composable
internal fun NestedScreen() {
    val backStack = rememberNavBackStack<BottomBarScreen>(BottomBarScreen.Home)
    var currentBottomBar: BottomBarScreen by rememberSaveable(
        stateSaver = BottomBarScreenSaver
    ) { mutableStateOf(BottomBarScreen.Home) }

    Scaffold(
        bottomBar = {
            HabitTrackerBottomBar(
                bottomItems = bottomBarItems,
                selectedItem = currentBottomBar,
                navigate = { bottomItem ->
                    if (bottomItem in bottomBarItems) {
                        backStack.removeAt(backStack.lastIndex)
                    }
                    backStack.add(bottomItem)
                    currentBottomBar = bottomItem
                }
            )
        }
    ) { paddingValues ->
        NavDisplay(
            modifier = Modifier.padding(paddingValues),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSceneSetupNavEntryDecorator(),
                rememberSavedStateNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                entry<BottomBarScreen.Home> {
                    SplashScreen { }
                }
                entry<BottomBarScreen.CalendarStats> {
                    SignInScreen()
                }
                entry<BottomBarScreen.Articles> {
                    SplashScreen { }
                }
                entry<BottomBarScreen.Profile> {
                    SignInScreen()
                }
            }
        )
    }
}