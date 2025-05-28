package com.danilincorporated.habit_tracker_android.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun HabitTrackerTheme(
    typography: HabitTrackerTypography = HabitTrackerTheme.typography,
    colors: HabitTrackerColors = HabitTrackerTheme.colors,
    offsets: HabitTrackerOffset = HabitTrackerTheme.offsets,
    shapes: HabitTrackerShapes = HabitTrackerTheme.shapes,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalHabitTrackerColors provides colors,
        LocalHabitTrackerTypography provides typography,
        LocalHabitTrackerOffset provides offsets,
        LocalHabitTrackerSpaces provides shapes,
        content = content,
    )
}


object HabitTrackerTheme {
    val typography: HabitTrackerTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalHabitTrackerTypography.current

    val colors: HabitTrackerColors
        @Composable
        @ReadOnlyComposable
        get() = LocalHabitTrackerColors.current

    val offsets: HabitTrackerOffset
        @Composable
        @ReadOnlyComposable
        get() = LocalHabitTrackerOffset.current

    val shapes: HabitTrackerShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalHabitTrackerSpaces.current
}