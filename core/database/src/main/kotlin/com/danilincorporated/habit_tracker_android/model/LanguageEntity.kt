package com.danilincorporated.habit_tracker_android.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("languages_table")
data class LanguageEntity(
    @PrimaryKey(autoGenerate = false)
    val languageId: String,
    val emojiImageCode: String,
    val placeholder: String,
    val isPreferred: Boolean
)