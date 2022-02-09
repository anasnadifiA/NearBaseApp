package com.primelab.NearBase.model

import com.primelab.NearBase.data.networks.response.WalletResponse

data class Wallet(
    val id: Int,
    val address: String,
    val name: String,
    val selected: Boolean
)

fun Wallet.toDomainModel() = kotlin.run {
    Wallet(
        id = id,
        name = name.toString(),
        address = address.toString(),
        selected = selected ?: false
    )
}

