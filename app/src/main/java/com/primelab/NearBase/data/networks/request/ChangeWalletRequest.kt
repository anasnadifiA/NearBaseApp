package com.primelab.NearBase.data.networks.request

import com.primelab.NearBase.model.Wallet


data class ChangeWalletRequest(
    val id: Int
)

fun Wallet.toRequest() = kotlin.run {
    ChangeWalletRequest(id)
}