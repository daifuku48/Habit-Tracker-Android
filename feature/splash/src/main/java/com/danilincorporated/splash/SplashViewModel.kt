package com.danilincorporated.splash

import com.danilincorporated.habit_tracker_android.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(

) : StateViewModel<SplashState>(SplashState()) {
}