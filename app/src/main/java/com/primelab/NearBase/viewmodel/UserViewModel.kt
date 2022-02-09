package com.primelab.NearBase.viewmodel


import androidx.lifecycle.ViewModel
import com.primelab.NearBase.data.preference.SharePrefs
import com.primelab.NearBase.extensions.resultFlow
import com.primelab.NearBase.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: Repository, sharePrefsRepository: SharePrefs) : ViewModel() {

    var prefs :SharePrefs = sharePrefsRepository
    var currentEmail: String = sharePrefsRepository.currentEmail
    var currentPhone: String = sharePrefsRepository.currentPhone
    var usesPhone: Boolean = false
    var walletName = sharePrefsRepository.walletName
    val loginType = sharePrefsRepository.loginType
    val loggedIn = sharePrefsRepository.accessToken.isNotEmpty() || sharePrefsRepository.accessToken.isNotBlank()


    fun createUser(name: String, walletId: String, claimNFTID: String? = null) = resultFlow {
        repository.createUser(name, walletId, currentPhone, currentEmail, claimNFTID)
    }

    fun loginUser(walletName: String) = resultFlow {
        repository.login(walletName)
    }

    fun verifyUser(walletName: String, nonce: String) = resultFlow {
        repository.verifyLogin(walletName, nonce)
    }

    fun updateUser(userId: String) = resultFlow {
        repository.modifyUser(userId, currentPhone, currentEmail)
    }


}