package com.danilincorporated.habit_tracker_android.di

import com.danilincorporated.habit_tracker_android.localization.StringReceiver
import com.danilincorporated.habit_tracker_android.localization.StringReceiverImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalizationModule {
    @Binds
    @Singleton
    fun bindStringReceiver(impl: StringReceiverImpl): StringReceiver
}