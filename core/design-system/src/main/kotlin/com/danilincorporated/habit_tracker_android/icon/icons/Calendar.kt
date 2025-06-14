package com.danilincorporated.habit_tracker_android.icon.icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

internal val Calendar: ImageVector
    get() {
        if (_Calendar != null) {
            return _Calendar!!
        }
        _Calendar = ImageVector.Builder(
            name = "Group 4",
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
                moveTo(6.444f, 6.5f)
                horizontalLineTo(37.556f)
                curveTo(40.01f, 6.5f, 42f, 8.291f, 42f, 10.5f)
                verticalLineTo(38.5f)
                curveTo(42f, 40.709f, 40.01f, 42.5f, 37.556f, 42.5f)
                horizontalLineTo(6.444f)
                curveTo(3.99f, 42.5f, 2f, 40.709f, 2f, 38.5f)
                verticalLineTo(10.5f)
                curveTo(2f, 8.291f, 3.99f, 6.5f, 6.444f, 6.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFF1F1F1)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(13.111f, 2.5f)
                verticalLineTo(10.5f)
                moveTo(42f, 18.5f)
                horizontalLineTo(2f)
                moveTo(30.889f, 2.5f)
                verticalLineTo(10.5f)
                moveTo(10.889f, 26.5f)
                horizontalLineTo(24.222f)
                moveTo(19.778f, 34.5f)
                horizontalLineTo(33.111f)
                moveTo(33.111f, 26.5f)
                horizontalLineTo(33.089f)
                moveTo(10.889f, 34.5f)
                horizontalLineTo(10.867f)
            }
        }.build()

        return _Calendar!!
    }

@Suppress("ObjectPropertyName")
private var _Calendar: ImageVector? = null

@Preview
@Composable
private fun CalendarPreview() {
    Icon(imageVector = Calendar, contentDescription = null)
}