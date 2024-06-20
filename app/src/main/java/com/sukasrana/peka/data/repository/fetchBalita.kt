package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Fungsi untuk mengambil Balita dari API
suspend fun fetchBaliat(): List<Balita>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getBalita()
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchBaliat", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchBaliat", "Exception: $e")
        null
    }
}

suspend fun fetchBaliatById(id_balita: Int): List<Balita>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getBalitaById(id_balita)
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchBaliat", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchBaliat", "Exception: $e")
        null
    }
}