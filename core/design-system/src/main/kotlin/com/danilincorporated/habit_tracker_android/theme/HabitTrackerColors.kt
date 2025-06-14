package com.danilincorporated.habit_tracker_android.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class HabitTrackerColors(
    val background: Color = Color(0xFFf1f1f1),
    val contentColor: Color = Color(0xFF010101),
    val primaryColor: Color = Color(0xFFB7B5E4),
    val darkGreen: Color = Color(0xFF003249),
    val orange: Color = Color(0xFFC97C5D),
    val lightWhite: Color = Color(0xFFF1F1F1),
    val onyx: Color = Color(0xFF0F0F0F),
)

val LocalHabitTrackerColors = staticCompositionLocalOf {
    HabitTrackerColors()
}