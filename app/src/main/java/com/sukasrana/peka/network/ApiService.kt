package com.sukasrana.peka.network

import com.sukasrana.peka.model.Article
import com.sukasrana.peka.model.ArticleResponse
import com.sukasrana.peka.model.MkiaResponse
import com.sukasrana.peka.model.MpasiResponse
import com.sukasrana.peka.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("user")
    suspend fun addUser(@Body user: User): Response<Unit>

    @GET("artikel")
    suspend fun readArtikel(): Response<ArticleResponse>

    @GET("mpasi")
    suspend fun readMpasi(): Response<MpasiResponse>

    @GET("mkia")
    suspend fun readMkia(): Response<MkiaResponse>

}