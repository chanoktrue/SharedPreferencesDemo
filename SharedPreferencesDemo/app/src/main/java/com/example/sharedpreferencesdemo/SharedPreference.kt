package com.example.sharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {

    private val prefName = "kotlinCodes"
    val sharedPref: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun setValue(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(key, value)
        editor!!.commit()
    }

    fun getValue(key: String): String? {
        return sharedPref?.getString(key, null)
    }

    fun removeValue(key: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(key)
        editor.commit()
    }

}