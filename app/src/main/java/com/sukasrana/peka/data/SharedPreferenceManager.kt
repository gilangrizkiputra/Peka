package com.sukasrana.peka.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("com.sukasrana.peka.PREFERENCES", Context.MODE_PRIVATE)

    companion object {
        private const val ONBOARDING_COMPLETED = "ONBOARDING_COMPLETED"
        private const val SELECT_REGISTER_OR_LOGIN = "SELECT_REGISTER_OR_LOGIN"
    }

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean(ONBOARDING_COMPLETED, false)
    }

    fun setOnboardingCompleted(completed: Boolean) {
        sharedPreferences.edit().putBoolean(ONBOARDING_COMPLETED, completed).apply()
    }

    fun isSelectRegisterOrLogin(): Boolean{
        return sharedPreferences.getBoolean(SELECT_REGISTER_OR_LOGIN, false)
    }

    fun setSelectRegisterOrLogin(completed: Boolean){
        sharedPreferences.edit().putBoolean(SELECT_REGISTER_OR_LOGIN, completed).apply()
    }
}