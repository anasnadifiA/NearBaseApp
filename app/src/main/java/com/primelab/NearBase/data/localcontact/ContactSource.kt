package com.primelab.NearBase.data.localcontact

import com.primelab.NearBase.model.Contact


interface ContactSource {
    suspend fun getAllContactWithEmail(userId: String): List<Contact>
}