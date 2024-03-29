package com.primelab.NearBase.data.networks.response

import com.google.gson.annotations.SerializedName

data class UserProfileResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val userInfo: UserResponse
)