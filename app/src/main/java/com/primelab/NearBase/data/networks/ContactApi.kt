package com.primelab.NearBase.data.networks

import com.primelab.NearBase.data.networks.response.BaseResponse
import com.primelab.NearBase.model.Contact
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContactApi {


    @POST("contacts/import")
    suspend fun importContact(@Body contact: List<Contact>): Response<ResponseBody>

    @POST("contacts")
    suspend fun addContact(@Body contact: Contact): Response<ResponseBody>

    @GET("contacts/list/{ownerId}")
    suspend fun getContacts(@Path("ownerId") ownerId: String): BaseResponse<List<Contact>>
}