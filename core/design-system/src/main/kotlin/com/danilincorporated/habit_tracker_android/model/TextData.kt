package com.danilincorporated.habit_tracker_android.model

import androidx.annotation.StringRes
import androidx.compose.ui.text.AnnotatedString

sealed interface TextData {
    data class Text(val value: String) : TextData
    data class Resource(@StringRes val resource: Int) : TextData
    data class AnnotatedText(val annotatedText: AnnotatedString) : TextData
    data class Html(val html: String) : TextData
}