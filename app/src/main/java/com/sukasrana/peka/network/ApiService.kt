package com.sukasrana.peka.network

import com.sukasrana.peka.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("user")
    suspend fun addUser(@Body user: User): Response<Unit>
}