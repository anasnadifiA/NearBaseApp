package com.primelab.NearBase.data.networks

import com.primelab.NearBase.data.networks.request.LoginRequest
import com.primelab.NearBase.data.networks.response.LoginResponse
import com.primelab.NearBase.data.networks.response.VerifyLoginResponse
import retrofit2.http.*

interface LoginApi {
    @POST("login")
    suspend fun login(@Body walletName : LoginRequest): LoginResponse

    @POST("login/verify")
    suspend fun verifyLogin(@Body walletName : LoginRequest): VerifyLoginResponse
}