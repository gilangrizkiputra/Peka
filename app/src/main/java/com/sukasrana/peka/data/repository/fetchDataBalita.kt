package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.DataBalita
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchDataBaliatById(id_balita: Int): List<DataBalita>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getDataBalitaById(id_balita)
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