package com.primelab.NearBase.data.preference

import android.content.SharedPreferences
import com.primelab.NearBase.extensions.boolean
import com.primelab.NearBase.extensions.string

class SharePrefs(private val sharePrefs: SharedPreferences) {

    var userId by sharePrefs.string()
    var userName by sharePrefs.string()
    var accessToken by sharePrefs.string()
    var idToken by sharePrefs.string()
    var refreshToken by sharePrefs.string()
    var loginType by sharePrefs.string()
    var walletName by sharePrefs.string()
    var userInfo by sharePrefs.string()
    var usesPhone by sharePrefs.boolean()
    var currentEmail by sharePrefs.string()
    var currentPhone by sharePrefs.string()

    fun registerKeyChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharePrefs.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unregisterKeyChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharePrefs.unregisterOnSharedPreferenceChangeListener(listener)
    }

    fun clear() {
        sharePrefs.edit().clear().apply()
    }

}