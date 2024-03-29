package com.primelab.NearBase.data.networks.interceptor

import com.primelab.NearBase.data.preference.SharePrefs
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class TokenInterceptor(private val sharePrefsRepository: SharePrefs) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val idToken = sharePrefsRepository.accessToken
        val requestBuilder = chain.request().newBuilder()
        Timber.i("Token %s", idToken)
        if (idToken.isNotEmpty()) {
            requestBuilder.header("Authorization", "Bearer $idToken")
        }
        return chain.proceed(requestBuilder.build())
    }
}