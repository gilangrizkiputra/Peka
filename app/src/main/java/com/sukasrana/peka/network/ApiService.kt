package com.sukasrana.peka.network

import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.BalitaResponse
import com.sukasrana.peka.model.DataBalitaResponse
import com.sukasrana.peka.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("user")
    suspend fun addUser(@Body user: User): Response<Unit>

    @POST("addbalita")
    suspend fun addBalita(@Body balita: Balita): Response<Unit>

    @GET("balita")
    suspend fun getBalita(): Response<BalitaResponse>

    @GET("balita/{id_balita}")
    suspend fun getBalitaById(@Path("id_balita") id_balita: Int): Response<BalitaResponse>

    @GET("databalita/{id_balita}")
    suspend fun getDataBalitaById(@Path("id_balita") id_balita: Int): Response<DataBalitaResponse>
}