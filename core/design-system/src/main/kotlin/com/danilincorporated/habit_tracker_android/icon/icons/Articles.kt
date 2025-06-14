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

internal val Articles: ImageVector
    get() {
        if (_Articles != null) {
            return _Articles!!
        }
        _Articles = ImageVector.Builder(
            name = "Group 6",
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
                moveTo(25.966f, 2.5f)
                horizontalLineTo(39.709f)
                curveTo(40.974f, 2.5f, 42f, 3.495f, 42f, 4.722f)
                verticalLineTo(40.278f)
                curveTo(42f, 41.505f, 40.974f, 42.5f, 39.709f, 42.5f)
                horizontalLineTo(25.966f)
                curveTo(24.701f, 42.5f, 23.675f, 41.505f, 23.675f, 40.278f)
                verticalLineTo(4.722f)
                curveTo(23.675f, 3.495f, 24.701f, 2.5f, 25.966f, 2.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFF1F1F1)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(32.838f, 2.5f)
                verticalLineTo(42.5f)
                moveTo(2.144f, 37.833f)
                curveTo(1.685f, 38.944f, 2.373f, 40.278f, 3.518f, 40.722f)
                lineTo(7.87f, 42.278f)
                curveTo(9.015f, 42.722f, 10.39f, 42.056f, 10.848f, 40.944f)
                lineTo(23.446f, 7.167f)
                curveTo(23.904f, 6.056f, 23.217f, 4.722f, 22.072f, 4.278f)
                lineTo(17.72f, 2.722f)
                curveTo(16.574f, 2.278f, 15.2f, 2.944f, 14.742f, 4.056f)
                lineTo(2.144f, 37.833f)
                close()
            }
        }.build()

        return _Articles!!
    }

@Suppress("ObjectPropertyName")
private var _Articles: ImageVector? = null

@Preview
@Composable
private fun PreviewArticles() {
    Icon(imageVector = Articles, contentDescription = null)
}