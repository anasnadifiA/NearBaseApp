package com.primelab.NearBase.model.settings

import com.primelab.NearBase.model.Wallet

data class Profile(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val wallet: Wallet,
    val security: Security,
)