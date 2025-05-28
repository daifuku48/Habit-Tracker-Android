package com.danilincorporated.habit_tracker_android

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danilincorporated.habit_tracker_android.model.Alert

@Composable
inline fun<reified VM: BaseViewModel> Screen(
    content: @Composable (VM) -> Unit
) {
   val viewModel = hiltViewModel<VM>()
    ScreenContent(viewModel, content)
}

@Composable
inline fun<reified VM: BaseViewModel> ScreenContent(
    viewModel: VM,
    content: @Composable (VM) -> Unit,
) {
    val loading by viewModel.loading.collectAsStateWithLifecycle(false)
    val alert by viewModel.alert.collectAsStateWithLifecycle(null)
    val latestSavedAlert by viewModel.latestSavedAlert.collectAsStateWithLifecycle(Alert.empty())

    val isSystemBackDisabled by remember(alert) {
        derivedStateOf { alert != null }
    }
    Box {
        content(viewModel)
        AnimatedVisibility(
            visible = loading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(FrekuentTheme.colors.white.copy(alpha = 0.5f))
                    .clickableNoRipple { },
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(54.dp)
                        .align(Alignment.Center),
                    strokeWidth = 4.dp,
                    strokeCap = StrokeCap.Round,
                    color = FrekuentTheme.colors.purple
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = alert != null,
            enter = fadeIn(),
            exit = fadeOut(),
            label = ""
        ) {
            val alert = alert ?: latestSavedAlert
            FrekuentAlert(
                modifier = Modifier.fillMaxSize(),
                alertData = alert.data,
                onAction = { action -> viewModel.onAlertClick(alert.type, action) },
                onDismiss = { viewModel.onAlertCancel(alert.type) },
                onTextChanged = { type, text -> viewModel.changeAlertTextFieldValue(type, text) }
            )
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = blockingScreen != null,
            enter = fadeIn(),
            exit = fadeOut(),
            label = ""
        ) {
            val blockingScreen = blockingScreen ?: latestSavedBlockingScreen
            FrekuentBlockingScreen(
                data = blockingScreen,
                onRetry = { viewModel.onBlockingRetry(blockingScreen.actionId) }
            )
        }
    }

    OnBackEventListener(
        onBack = {
            if (alert?.data?.canBeDismissed?.not() == true) return@OnBackEventListener
            viewModel.onAlertCancel(alert?.type ?: return@OnBackEventListener)
        },
        disableSystemBackPressed = isSystemBackDisabled,
    )
}

@Composable
fun OnBackEventListener(
    onBack: () -> Unit,
    disableSystemBackPressed: Boolean = false,
    enabled: Boolean = true,
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current

    val currentOnBack by rememberUpdatedState(onBack)
    val disable by rememberUpdatedState(disableSystemBackPressed)

    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                if (!disable) {
                    isEnabled = false
                    backDispatcher?.onBackPressed()
                }
                currentOnBack()
            }
        }
    }
    SideEffect {
        backCallback.isEnabled = enabled
    }
    DisposableEffect(lifecycleOwner, backDispatcher) {
        backDispatcher?.addCallback(lifecycleOwner, backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}
