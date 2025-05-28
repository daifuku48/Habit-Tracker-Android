package com.danilincorporated.habit_tracker_android.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danilincorporated.habit_tracker_android.HabitTrackerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): RoomDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = HabitTrackerDatabase::class.java,
            name = "habit_tracker_database"
        ).build()
    }
}