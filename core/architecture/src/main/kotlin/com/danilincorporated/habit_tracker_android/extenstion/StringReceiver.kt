package com.danilincorporated.habit_tracker_android.extenstion

import com.danilincorporated.habit_tracker_android.extension.toTextData
import com.danilincorporated.habit_tracker_android.localization.StringReceiver
import com.danilincorporated.habit_tracker_android.model.TextData

suspend fun StringReceiver.getTextData(placeholder: String): TextData =
    getString(placeholder).toTextData()
