package com.sukasrana.peka.data.repository

import android.util.Log
import com.sukasrana.peka.model.User
import com.sukasrana.peka.model.UserResponse
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetcUser(id_user: Int): List<User>? {
    return try {
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.readUserById(id_user)
            if (response.isSuccessful) {
                response.body()?.data
            } else {
                Log.e("fetchuser", "Response failed: ${response.errorBody()}")
                null
            }
        }
    } catch (e: Exception) {
        Log.e("fetchuser", "Exception: $e")
        null
    }
}