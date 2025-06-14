package com.danilincorporated.habit_tracker_android.navigation

import com.danilincorporated.habit_tracker_android.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor() : StateViewModel<MainState>(MainState()) {
}