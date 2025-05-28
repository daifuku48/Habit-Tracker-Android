package com.danilincorporated.habit_tracker_android.localization

import com.danilincorporated.habit_tracker_android.model.DomainLanguage
import kotlinx.coroutines.flow.SharedFlow

interface StringReceiver {
    val textUpdated: SharedFlow<Unit>
    suspend fun getLanguages(): List<DomainLanguage>
    suspend fun getString(key: String): String
    suspend fun loadStrings()
    suspend fun changeCurrentLanguage(newLanguage: String): Boolean
    suspend fun getCurrentLanguage(): String
}