package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.Mkia
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchMkia(): List<Mkia>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.readMkia()
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchMkia", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchMkia", "Exception: $e")
        null
    }
}