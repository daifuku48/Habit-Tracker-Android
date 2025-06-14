package com.danilincorporated.habit_tracker_android.extension

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

private var lastClickTime = 0L
private const val CLICK_INTERVAL = 500L

fun performWithTimeout(
    action: () -> Unit,
) = performWithTimeout(
    action = action,
    interval = CLICK_INTERVAL
)

fun performWithTimeout(
    action: () -> Unit,
    interval: Long = CLICK_INTERVAL,
) {
    require(CLICK_INTERVAL <= interval)
    val now = System.currentTimeMillis()
    if (now - lastClickTime > interval) {
        lastClickTime = now
        action()
    }
}

fun Modifier.clickableSingle(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    interval: Long = CLICK_INTERVAL,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier {
    return this then Modifier.clickable(
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = {
            performWithTimeout(
                action = onClick,
                interval = interval
            )
        }
    )
}

@Composable
fun Modifier.clickableNoRipple(
    enabled: Boolean = true,
    interval: Long = CLICK_INTERVAL,
    onClick: () -> Unit,
) = clickableSingle(
    interactionSource = remember { MutableInteractionSource() },
    indication = null,
    interval = interval,
    enabled = enabled,
    onClick = onClick
)


inline fun Modifier.applyIf(condition: Boolean, modifier: Modifier.() -> Modifier): Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}