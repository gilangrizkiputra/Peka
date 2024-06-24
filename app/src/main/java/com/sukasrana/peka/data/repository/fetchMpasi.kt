package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchMpasi(): List<Mpasi>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.readMpasi()
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchMpasi", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchMpasi", "Exception: $e")
        null
    }
}