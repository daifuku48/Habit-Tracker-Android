package com.danilincorporated.habit_tracker_android.icon.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

internal val Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Group 3",
            defaultWidth = 44.dp,
            defaultHeight = 45.dp,
            viewportWidth = 44f,
            viewportHeight = 45f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF0F0F0F)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15.333f, 42.5f)
                verticalLineTo(25.658f)
                curveTo(15.333f, 25.099f, 15.567f, 24.564f, 15.984f, 24.169f)
                curveTo(16.401f, 23.774f, 16.966f, 23.552f, 17.556f, 23.552f)
                horizontalLineTo(26.444f)
                curveTo(27.034f, 23.552f, 27.599f, 23.774f, 28.016f, 24.169f)
                curveTo(28.433f, 24.564f, 28.667f, 25.099f, 28.667f, 25.658f)
                verticalLineTo(42.5f)
            }
            path(
                stroke = SolidColor(Color(0xFF0F0F0F)),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(42f, 19.341f)
                curveTo(42f, 18.729f, 41.859f, 18.124f, 41.587f, 17.568f)
                curveTo(41.315f, 17.013f, 40.918f, 16.52f, 40.424f, 16.125f)
                lineTo(24.869f, 3.495f)
                curveTo(24.067f, 2.852f, 23.05f, 2.5f, 22f, 2.5f)
                curveTo(20.95f, 2.5f, 19.933f, 2.852f, 19.131f, 3.495f)
                lineTo(3.576f, 16.125f)
                curveTo(3.082f, 16.52f, 2.685f, 17.013f, 2.413f, 17.568f)
                curveTo(2.141f, 18.124f, 2f, 18.729f, 2f, 19.341f)
                verticalLineTo(38.289f)
                curveTo(2f, 39.406f, 2.468f, 40.477f, 3.302f, 41.267f)
                curveTo(4.135f, 42.056f, 5.266f, 42.5f, 6.444f, 42.5f)
                horizontalLineTo(37.556f)
                curveTo(38.734f, 42.5f, 39.865f, 42.056f, 40.698f, 41.267f)
                curveTo(41.532f, 40.477f, 42f, 39.406f, 42f, 38.289f)
                verticalLineTo(19.341f)
                close()
            }
        }.build()

        return _Home!!
    }

@Suppress("ObjectPropertyName")
private var _Home: ImageVector? = null

@Preview
@Composable
private fun PreviewHome() {
    androidx.compose.material3.Icon(imageVector = Home, contentDescription = null)
}
