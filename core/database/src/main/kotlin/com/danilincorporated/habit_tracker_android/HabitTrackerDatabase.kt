package com.danilincorporated.habit_tracker_android

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danilincorporated.habit_tracker_android.dao.LocalizationDao
import com.danilincorporated.habit_tracker_android.model.LanguageEntity
import com.danilincorporated.habit_tracker_android.model.LocaleEntity

@Database(
    entities = [
        LanguageEntity::class,
        LocaleEntity::class,
    ],
    version = 1
)
abstract class HabitTrackerDatabase : RoomDatabase() {
    abstract fun localizationDao(): LocalizationDao
}