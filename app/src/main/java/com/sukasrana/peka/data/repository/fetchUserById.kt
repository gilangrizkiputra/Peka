package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.User
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchUserById(id_user: Int): User? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.readUserById(id_user)
            if (response.isSuccessful) {
                response.body()?.data?.firstOrNull()
            } else {
                Log.e("fetchUser", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchUser", "Exception: $e")
        null
    }
}

suspend fun updateUser(id_user: Int, user: User): Boolean {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.updateUser(id_user, user)
            response.isSuccessful
        }
    } catch (e: Exception) {
        Log.e("updateUser", "Exception: $e")
        false
    }
}