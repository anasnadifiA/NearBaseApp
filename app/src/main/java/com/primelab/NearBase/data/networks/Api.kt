package com.primelab.NearBase.data.networks

import com.google.gson.JsonObject
import com.primelab.NearBase.data.networks.request.AddWalletRequest
import com.primelab.NearBase.data.networks.request.ChangeWalletRequest
import com.primelab.NearBase.data.networks.request.LoginRequest
import com.primelab.NearBase.data.networks.request.UserCreateRequest
import com.primelab.NearBase.data.networks.response.*

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @GET("api/users")
    suspend fun sampleGet(): JsonObject

    @GET("api/wallets")
    suspend fun getWallets(): WalletResponse

    @POST("api/change_wallet")
    suspend fun changeWallet(@Body request: ChangeWalletRequest): Response<ResponseBody>

    @POST("api/add_wallet")
    suspend fun addWallet(@Body request: AddWalletRequest): Response<ResponseBody>

    @GET("users/{user_id}")
    suspend fun getUserProfile(@Path("user_id") userId: String): UserProfileResponse

    @PUT("users/{user_id}")
    suspend fun modifyUser(@Path("user_id") userId: String, @Body request: UserCreateRequest): UserInfoResponse

    @POST("login")
    suspend fun login(@Body walletName : LoginRequest): LoginResponse

}