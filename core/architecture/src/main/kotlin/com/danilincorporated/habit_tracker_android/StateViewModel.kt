package com.danilincorporated.habit_tracker_android

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class StateViewModel<State>(
    initialState: State,
) : BaseViewModel(){
    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()
}