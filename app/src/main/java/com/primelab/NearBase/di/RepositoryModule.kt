package com.primelab.NearBase.di

import android.content.Context
import com.nft.signdoc.repository.SettingsRepository
import com.primelab.NearBase.data.localcontact.ContactSource
import com.primelab.NearBase.data.localcontact.LocalContact
import com.primelab.NearBase.data.networks.Api
import com.primelab.NearBase.data.networks.ContactApi
import com.primelab.NearBase.data.networks.LoginApi
import com.primelab.NearBase.data.networks.UserApi
import com.primelab.NearBase.data.preference.SharePrefs
import com.primelab.NearBase.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        api: Api,
        contactApi: ContactApi,
        userApi: UserApi,
        loginApi: LoginApi,
        sharePrefs: SharePrefs,
        localContact: ContactSource
    ) =
        Repository(
            api,
            contactApi,
            userApi,
            loginApi,
            sharePrefs,
            localContact
        )

    @Provides
    @Singleton
    fun provideSettingsRepository(api: Api, sharePrefs: SharePrefs) =
        SettingsRepository(api, sharePrefs)

    @Provides
    @Singleton
    fun providerContactSource(@ApplicationContext context: Context): ContactSource =
        LocalContact(context)
}