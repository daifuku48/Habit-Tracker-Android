package com.danilincorporated.habit_tracker_android.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.danilincorporated.habit_tracker_android.Screen
import com.danilincorporated.habit_tracker_android.navigation.featureRoutes.authRoute
import com.danilincorporated.habit_tracker_android.navigation.featureRoutes.nestedGraphRoutes
import com.danilincorporated.habit_tracker_android.navigation.featureRoutes.splashRoutes
import com.danilincorporated.habit_tracker_android.navigation.screens.Screens
import com.danilincorporated.habit_tracker_android.theme.HabitTrackerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideSystemBars()
        setContent {
            HabitTrackerTheme {
                Screen<MainViewModel> { viewModel ->
                    val state = viewModel.state.collectAsState()

                    HabitTrackerApp()
                }
            }
        }
    }
    private fun hideSystemBars() {
        val controller = WindowInsetsControllerCompat(
            window, window.decorView
        )
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

@Composable
private fun HabitTrackerApp() {
    val backStack = remember { mutableStateListOf<Screens>(Screens.NestedGraph) }
    NavDisplay(
        modifier = Modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            splashRoutes(backStack)
            authRoute(backStack)
            nestedGraphRoutes(backStack)
        }
    )
}
