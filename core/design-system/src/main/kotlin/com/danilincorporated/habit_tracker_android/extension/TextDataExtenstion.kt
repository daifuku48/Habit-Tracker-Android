package com.danilincorporated.habit_tracker_android.extension

import com.danilincorporated.habit_tracker_android.model.TextData

fun String.toTextData() : TextData {
    return TextData.Text(this)
}