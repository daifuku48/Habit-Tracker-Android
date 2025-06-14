package com.danilincorporated.habit_tracker_android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danilincorporated.habit_tracker_android.alert.Message
import com.danilincorporated.habit_tracker_android.common.exception.NetworkAbsenceException
import com.danilincorporated.habit_tracker_android.extension.toButtonData
import com.danilincorporated.habit_tracker_android.extension.toTextData
import com.danilincorporated.habit_tracker_android.model.Alert
import com.danilincorporated.habit_tracker_android.model.AlertData
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel(
//    private val stringReceiver: StringReceiver
): ViewModel() {
    private val _loadingSet = MutableStateFlow<Set<String>>(emptySet())
    val loading = _loadingSet.map { it.isNotEmpty() }

    private val _alert = MutableStateFlow<Alert?>(null)
    val alert = _alert.asStateFlow()
    val latestSavedAlert = alert.filterNotNull()

    private val actionsMap = mutableMapOf<String, () -> Unit>()

    protected fun addLoading(actionId: String) {
        _loadingSet.update { it + actionId }
    }

    protected fun removeLoading(actionId: String) {
        _loadingSet.update { it - actionId }
    }

    fun launch(
        actionId: String = UUID.randomUUID().toString(),
        context: CoroutineContext = EmptyCoroutineContext,
        loadingEnabled: Boolean = false,
        onNetworkAbsenceException: ((String) -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit,
    ) {
        saveAction(context, actionId, block)
        viewModelScope.launch(context = context) {
            try {
                if (loadingEnabled) addLoading(actionId)
                block()
            } catch (throwable: Throwable) {
                when (throwable.cause) {
                    is NetworkAbsenceException -> {
                        if (onNetworkAbsenceException != null) {
                            onNetworkAbsenceException(actionId)
                        } else {
                            showNetworkAbsenceAlert(actionId)
                        }
                    }
                }
                throwable.printStackTrace()
            } finally {
                removeLoading(actionId)
            }
        }
    }

    private fun showNetworkAbsenceAlert(
        actionId: String,
    ) {

    }

    private fun saveAction(
        context: CoroutineContext,
        actionId: String,
        action: suspend CoroutineScope.() -> Unit,
    ) {
        actionsMap[actionId] = {
            launch(
                context = context,
                actionId = actionId,
                block = action,
                onNetworkAbsenceException = null
            )
        }
    }

    protected fun hideAlert() {
        _alert.value = null
    }

    protected fun showAlert(alert: Alert) {
        _alert.value = alert
    }

    protected suspend fun showMessageAlert(
        titlePlaceHolder: String,
        messagePlaceHolder: String,
        buttonPlaceHolder: String
    ) {
        val data = AlertData(
            title = "".toTextData(),
            subtitle ="".toTextData(),
            buttons = persistentListOf(
                AlertData.Button(
                    data = (buttonPlaceHolder).toButtonData(),
                    action = Message.Cancel,
                    type = AlertData.Button.ButtonType.Outlined
                )
            )
        )
        showAlert(Alert(data = data, type = Message))
    }

    companion object {
        const val NETWORK_ERROR_TITLE = "internet_error_title"
        const val NETWORK_ERROR_SUBTITLE = "internet_error_description"
        const val NETWORK_ERROR_BUTTON = "internet_error_try_again_button"
    }
}