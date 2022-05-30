package com.example.zyy_sendwater.util

import android.content.Context
import android.content.SharedPreferences
import com.example.zyy_sendwater.App

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 16:55
 */
object SPUtil {


    fun sp(name: String,context: Context):SharedPreferences{
        return App.appContext.getSharedPreferences(name,Context.MODE_PRIVATE)
    }

    fun putString(name:String,context: Context):SharedPreferences.Editor {
        return App.appContext.getSharedPreferences(name,Context.MODE_PRIVATE).edit()
    }

    fun getTokenSP(): String? {
        return App.appContext.getSharedPreferences("user",Context.MODE_PRIVATE).getString("token","")
    }

}