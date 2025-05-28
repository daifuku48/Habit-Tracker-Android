package com.danilincorporated.habit_tracker_android.model

data class Alert (
    val type: Type,
    val data: AlertData,
) {
    interface Type
    data object Empty : Type

    companion object {
        fun empty(): Alert = Alert(Empty, AlertData.empty())
    }
}