package com.danilincorporated.habit_tracker_android.dao

import androidx.room.Query
import androidx.room.Upsert
import com.danilincorporated.habit_tracker_android.model.LanguageEntity
import com.danilincorporated.habit_tracker_android.model.LocaleEntity

interface LocalizationDao {
    @Query("SELECT * FROM locale_table")
    suspend fun getLocales(): List<LocaleEntity>

    @Query("SELECT * FROM languages_table")
    suspend fun getLanguages(): List<LanguageEntity>

    @Upsert
    suspend fun setLocales(locales: List<LocaleEntity>)

    @Upsert
    suspend fun setLanguages(locales: List<LanguageEntity>)

    @Query("UPDATE languages_table SET isPreferred = 0")
    suspend fun resetPreferredLanguage()

    @Query("UPDATE languages_table SET isPreferred = true WHERE languageId = :newPreferredLanguage")
    suspend fun setPreferredLanguage(newPreferredLanguage: String)

    @Query("DELETE FROM locale_table")
    suspend fun removeLocales()

    @Query("DELETE FROM locale_table")
    suspend fun removeLanguages()
}