package com.example.zyy_sendwater.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.util
 * @description: zyy21
 * @date :2022/7/22 17:36
 */
//Jetpack DataStore 是一种数据存储解决方案，允许您使用协议缓冲区存储键值对或类型化对象。DataStore 使用 Kotlin 协程和 Flow 以异步、一致的事务方式存储数据。
//Preferences DataStore 和 Proto DataStore
//DataStore 提供两种不同的实现：Preferences DataStore 和 Proto DataStore。
//
//Preferences DataStore 使用键存储和访问数据。此实现不需要预定义的架构，也不确保类型安全。
//Proto DataStore 将数据作为自定义数据类型的实例进行存储。此实现要求您使用协议缓冲区来定义架构，但可以确保类型安全。
object DateStoreUtil {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
}