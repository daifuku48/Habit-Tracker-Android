package com.danilincorporated.habit_tracker_android.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Profile: ImageVector
    get() {
        if (_Profile != null) {
            return _Profile!!
        }
        _Profile = ImageVector.Builder(
            name = "Profile",
            defaultWidth = 44.dp,
            defaultHeight = 45.dp,
            viewportWidth = 44f,
            viewportHeight = 45f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFF1F1F1)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(22f, 42.5f)
                curveTo(10.954f, 42.5f, 2f, 33.546f, 2f, 22.5f)
                curveTo(2f, 11.454f, 10.954f, 2.5f, 22f, 2.5f)
                curveTo(33.046f, 2.5f, 42f, 11.454f, 42f, 22.5f)
                curveTo(42f, 33.546f, 33.046f, 42.5f, 22f, 42.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFF1F1F1)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(22f, 24.5f)
                curveTo(18.686f, 24.5f, 16f, 21.814f, 16f, 18.5f)
                curveTo(16f, 15.186f, 18.686f, 12.5f, 22f, 12.5f)
                curveTo(25.314f, 12.5f, 28f, 15.186f, 28f, 18.5f)
                curveTo(28f, 21.814f, 25.314f, 24.5f, 22f, 24.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFF1F1F1)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(32f, 39.824f)
                verticalLineTo(36.5f)
                curveTo(32f, 35.439f, 31.579f, 34.422f, 30.828f, 33.672f)
                curveTo(30.078f, 32.921f, 29.061f, 32.5f, 28f, 32.5f)
                horizontalLineTo(16f)
                curveTo(14.939f, 32.5f, 13.922f, 32.921f, 13.172f, 33.672f)
                curveTo(12.421f, 34.422f, 12f, 35.439f, 12f, 36.5f)
                verticalLineTo(39.824f)
            }
        }.build()

        return _Profile!!
    }

@Suppress("ObjectPropertyName")
private var _Profile: ImageVector? = null
