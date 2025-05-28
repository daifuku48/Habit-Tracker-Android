package com.danilincorporated.habit_tracker_android.model

import com.danilincorporated.habit_tracker_android.extension.toTextData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class AlertData(
    val title: TextData,
    val subtitle: TextData? = null,
    val textFields: ImmutableList<TextField> = persistentListOf(),
    val buttons: ImmutableList<Button> = persistentListOf(),
    val canBeDismissed: Boolean = true,
) {
    data class TextField(
        val type: TextFieldType,
        val data: TextFieldData,
        val inputType: InputType,
    ) {
        interface TextFieldType

        enum class InputType {
            Text, Password
        }
    }

    data class Button(
        val action: Action,
        val data: ButtonData,
        val type: ButtonType,
    ) {
        interface Action

        sealed interface ButtonType {
            data class Default(
                val backgroundColor: BackgroundColor = BackgroundColor.Purple
            ) : ButtonType

            data object Outlined : ButtonType
            data object Text : ButtonType
        }

        enum class BackgroundColor {
            Purple, Red
        }
    }

    companion object {
        fun empty(): AlertData = AlertData(
            title = "".toTextData(),
            subtitle = "".toTextData(),
            textFields = persistentListOf(),
            buttons = persistentListOf(),
        )
    }
}
