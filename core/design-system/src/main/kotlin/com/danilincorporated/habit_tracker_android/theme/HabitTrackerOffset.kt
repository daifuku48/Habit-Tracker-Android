package com.danilincorporated.habit_tracker_android.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class HabitTrackerOffset(
    val small: Dp = 10.dp,
)

val LocalHabitTrackerOffset = staticCompositionLocalOf {
    HabitTrackerOffset()
}

