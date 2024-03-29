package com.primelab.NearBase.model

import android.net.Uri
import com.primelab.NearBase.data.networks.response.DtoContact
import com.primelab.NearBase.data.networks.response.DtoContactAddress
import com.primelab.NearBase.data.networks.response.DtoContactEmail
import com.primelab.NearBase.data.networks.response.DtoContactPhone

data class Contact(
    val birthday: String? = null,
    val address: List<ContactAddress>? = null,
    val archivedDate: Long? = null,
    val created: Long? = null,
    var last_name: String? = null,
    val groups: List<String>? = null,
    val companies: List<String>? = null,
    var phone: List<ContactPhone>? = null,
    val dob: String = "",
    val isImported: Boolean? = null,
    val contactUserId: String? = null,
    val importSource: String? = null,
    var first_name: String? = null,
    val jobTitle: String? = null,
    val appId: String? = null,
    val updated: Long? = null,
    var email: List<ContactEmail>? = null,
    val status: String? = null,
    var owner_id: String? = null,
    var id: String? = null,
    var imageUri: Uri? = null,
)

data class ContactEmail(
    val address: String? = null,
    val type: String? = null
)

data class ContactAddress(
    val country: String? = null,
    val city: String? = null,
    val formatted: String? = null,
    val street: String? = null,
    val region: String? = null,
    val postalCode: String? = null,
    val type: String? = null
)

data class ContactPhone(
    val number: String? = null,
    val type: String? = null
)

fun DtoContact?.toDomainModel() = this?.run {
    Contact(
        birthday = birthday,
        address = address?.mapNotNull { it.toDomainModel() },
        archivedDate = archivedDate?.toLongOrNull(),
        created = created?.toLongOrNull(),
        last_name = lastName,
        groups = groups,
        companies = companies,
        phone = phone?.mapNotNull { it.toDomainModel() },
        dob = dob ?: "",
        isImported = isImported,
        contactUserId = contactUserId,
        importSource = importSource,
        first_name = firstName,
        jobTitle = jobTitle,
        appId = appId,
        updated = updated?.toLongOrNull(),
        email = email?.mapNotNull { it.toDomainModel() },
        status = status,
        owner_id = ownerId
    )
}

fun DtoContactEmail?.toDomainModel() = this?.run {
    ContactEmail(
        address = address,
        type = type
    )
}

fun DtoContactAddress?.toDomainModel() = this?.run {
    ContactAddress(
        country = country,
        city = country,
        formatted = formatted,
        street = street,
        region = region,
        postalCode = postalCode,
        type = type
    )
}

fun DtoContactPhone?.toDomainModel() = this?.run {
    ContactPhone(
        number = number,
        type = type
    )
}