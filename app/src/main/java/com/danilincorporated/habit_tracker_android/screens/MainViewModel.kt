package com.danilincorporated.habit_tracker_android.screens

import com.danilincorporated.habit_tracker_android.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel(
    private val stringReceiver:
): StateViewModel<MainState>(MainState()) {
}