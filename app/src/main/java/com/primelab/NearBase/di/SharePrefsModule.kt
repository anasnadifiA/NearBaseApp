package com.primelab.NearBase.di

import android.content.Context
import android.content.SharedPreferences
import com.primelab.NearBase.data.preference.SharePrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharePrefsModule {
    @PreferenceName
    @Provides
    @Singleton
    fun provideSharePrefsName() = "near-signdoc-prefs"

    @Provides
    @Singleton
    fun provideSharePreference(
        @ApplicationContext context: Context,
        @PreferenceName name: String
    ): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharePrefs(sharedPreferences: SharedPreferences) = SharePrefs(sharedPreferences)
}