package com.danilincorporated.habit_tracker_android.model

import androidx.room.Entity

@Entity(tableName = "locale_table", primaryKeys = ["placeholder, languageId"])
data class LocaleEntity(
    val placeholder: String,
    val languageId: String,
    val value: String,
)