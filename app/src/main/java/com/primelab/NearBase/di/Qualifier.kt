package com.primelab.NearBase.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ContactUrl


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PreferenceName