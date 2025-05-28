package com.danilincorporated.habit_tracker_android.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class HabitTrackerColors(
    val background: Color = Color(0xFFf1f1f1),
    val contentColor: Color = Color(0xFF010101),
)

val LocalHabitTrackerColors = staticCompositionLocalOf {
    HabitTrackerColors()
}