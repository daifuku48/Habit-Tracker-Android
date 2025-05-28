package com.danilincorporated.habit_tracker_android.alert

import com.danilincorporated.habit_tracker_android.model.Alert
import com.danilincorporated.habit_tracker_android.model.AlertData

data class Reload(val actionId: String) : Alert.Type {
    data object Reload : AlertData.Button.Action
}

data object Message : Alert.Type {
    data object Cancel : AlertData.Button.Action
}
