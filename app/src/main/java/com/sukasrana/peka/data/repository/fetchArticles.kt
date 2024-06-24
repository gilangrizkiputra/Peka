package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Fungsi untuk mengambil artikel dari API
suspend fun fetchArticles(): List<Article>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.readArtikel()
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchArticles", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchArticles", "Exception: $e")
        null
    }
}