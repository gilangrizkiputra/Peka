package com.sukasrana.peka.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceLogin(context: Context) {
        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("com.sukasrana.peka.PREFERENCESLOGIN", Context.MODE_PRIVATE)
        private val editor = sharedPreferences.edit()

        companion object {
            private const val IS_LOGGED_IN = "IS_LOGGED_IN"
            private const val EMAIL_KEY = "EMAIL_KEY"
            private const val PASSWORD_KEY = "PASSWORD_KEY"
        }

        var isLoggedIn: Boolean
            get() = sharedPreferences.getBoolean(IS_LOGGED_IN, false)
            set(value) {
                editor.putBoolean(IS_LOGGED_IN, value)
                editor.apply()
            }

        var email: String?
            get() = sharedPreferences.getString(EMAIL_KEY, "")
            set(value) {
                editor.putString(EMAIL_KEY, value)
                editor.apply()
            }

        var password: String?
            get() = sharedPreferences.getString(PASSWORD_KEY, "")
            set(value) {
                editor.putString(PASSWORD_KEY, value)
                editor.apply()
            }

        fun clear() {
            editor.clear()
            editor.apply()
        }
}