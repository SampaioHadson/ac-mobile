package com.example.brcommobileimovelparatodos

import android.app.Activity
import android.content.Context

class SharedPreferencesHelper {
    fun putStringPreference(activity : Activity, key : String, value : String) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getStringPreference(activity : Activity, key : String) : String? {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getString(key, null)
    }
}