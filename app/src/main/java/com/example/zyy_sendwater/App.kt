package com.example.zyy_sendwater

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 15:30
 */
class App : Application() {
    //companion object内部原生类，会将var自动生成get/set方法
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

}

