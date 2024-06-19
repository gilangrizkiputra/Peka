package com.sukasrana.peka.network

import com.sukasrana.peka.model.Balita
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("balita")
   suspend fun addBalita(@Body balita: Balita): Response<Unit>
}