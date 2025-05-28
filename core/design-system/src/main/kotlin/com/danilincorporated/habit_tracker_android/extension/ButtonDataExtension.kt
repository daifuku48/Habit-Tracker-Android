package com.danilincorporated.habit_tracker_android.extension

import com.danilincorporated.habit_tracker_android.model.ButtonData
import com.danilincorporated.habit_tracker_android.model.ButtonData.Image

fun String.toButtonData(
    enabled: Boolean = true,
    startImage: Image? = null,
    endImage: Image? = null,
) : ButtonData {
    return ButtonData(
        text = this.toTextData(),
    )
}