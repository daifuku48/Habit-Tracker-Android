package com.danilincorporated.habit_tracker_android.extension

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withSave
import com.danilincorporated.habit_tracker_android.theme.HabitTrackerTheme

@SuppressLint("SuspiciousModifierThen")
@Composable
fun Modifier.bottomShadow(
    color: Color = HabitTrackerTheme.colors.primaryColor.copy(alpha = 0.25f),
    radius: Dp = 4.dp,
    offsetY: Dp = 4.dp,
    shape: RoundedCornerShape = HabitTrackerTheme.shapes.small
): Modifier = this.then(
    drawBehind {
        val shadowRadius = radius.toPx()
        val shadowOffsetY = offsetY.toPx()

        val paint = Paint().asFrameworkPaint().apply {
            this.color = android.graphics.Color.TRANSPARENT
            setShadowLayer(shadowRadius, 0f, shadowOffsetY, color.toArgb())
            isAntiAlias = true
        }

        val outline = shape.createOutline(size, layoutDirection, this)
        val path = Path()

        when (outline) {
            is Outline.Rounded -> {
                path.addRoundRect(outline.roundRect)
            }
            is Outline.Rectangle -> {
                path.addRect(outline.rect)
            }
            is Outline.Generic -> {
                path.addPath(outline.path)
            }
        }

        drawIntoCanvas { canvas ->
            canvas.nativeCanvas.apply {
                withSave {
                    drawPath(path.asAndroidPath(), paint)
                }
            }
        }
    }
)
