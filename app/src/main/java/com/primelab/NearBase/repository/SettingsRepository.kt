package com.nft.signdoc.repository

import com.primelab.NearBase.data.networks.Api
import com.nft.signdoc.model.toDomain
import com.primelab.NearBase.data.networks.request.ChangeWalletRequest
import com.primelab.NearBase.data.networks.request.UserCreateRequest
import com.primelab.NearBase.data.preference.SharePrefs
import com.primelab.NearBase.extensions.safeCall

class SettingsRepository(private val api: Api, private val sharePrefs: SharePrefs) {


    suspend fun changeWallet(request: ChangeWalletRequest) = safeCall {
//        val response = api.changeWallet(request)
//        response.isSuccessful
        true
    }

    suspend fun addWallet(name: String) = safeCall {
//        val response = api.addWallet(DtoAddWalletRequest(name))
//        response.isSuccessful
        true
    }
    suspend fun getUserProfile(userId: String) = safeCall {
        val dtoResponse = api.getUserProfile(userId)
        dtoResponse.userInfo.toDomain()
    }

    suspend fun changeName(name: String, phone: String, email:String) = safeCall {
        val dToUser = UserCreateRequest(name, sharePrefs.walletName, phone, email)
        sharePrefs.userName = name
        api.modifyUser(sharePrefs.userId, dToUser)
    }

    suspend fun changeEmail(email: String, currentPhone: String) = safeCall {
        val dToUser = UserCreateRequest(sharePrefs.userName, sharePrefs.walletName, currentPhone, email)
        api.modifyUser(sharePrefs.userId, dToUser)
//        //if uses phone, just update it
//        if (sharePrefs.loginType == "phone")
//        {
//            api.modifyUser(sharePrefs.userId, dToUser)
//        }
//        else
//        {
//            //send OTP Request then change
//            val request = DtoLoginRequest(sharePrefs.walletName)
//            api.login(request)
//        }
    }

    suspend fun changePhone(phone: String, currentEmail: String) = safeCall {
        //if uses phone, have to do 2 factor
        val dToUser = UserCreateRequest(sharePrefs.userName, sharePrefs.walletName, phone, currentEmail)
        api.modifyUser(sharePrefs.userId, dToUser)
//        if (sharePrefs.loginType == "phone")
//        {
//            //send OTP Request then change
//            val request = DtoLoginRequest(sharePrefs.walletName)
//            api.login(request)
//        }
//        else
//        {
//            api.modifyUser(sharePrefs.userId, dToUser)
//        }
    }
}