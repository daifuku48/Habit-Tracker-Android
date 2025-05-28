package com.danilincorporated.habit_tracker_android.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ButtonData(
    val text: TextData,
    val enabled: Boolean = true,
    val startImage: Image? = null,
    val endImage: Image? = null,
) {
    data class Image(
        val vector: ImageVector,
        val isImage: Boolean = false,
    )

    companion object {
        fun ImageVector.toButtonImage(): Image {
            return Image(this, true)
        }

        fun ImageVector.toButtonIcon(): Image {
            return Image(this, false)
        }
    }
}
