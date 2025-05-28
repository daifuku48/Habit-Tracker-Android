package com.danilincorporated.habit_tracker_android.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class HabitTrackerShapes(
    val small: RoundedCornerShape = RoundedCornerShape(10.dp),
)

val LocalHabitTrackerSpaces = staticCompositionLocalOf {
    HabitTrackerShapes()
}