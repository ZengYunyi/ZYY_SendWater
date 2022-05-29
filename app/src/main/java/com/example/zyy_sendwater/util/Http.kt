package com.example.zyy_sendwater.util

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/5 18:51
 */
object Http {
    private val o = OkHttpClient()
    val g = Gson()
    val m: MediaType = "application/json".toMediaType()
    var base = "http://124.93.196.45:10001"
    var token: String? = null

    operator fun <T> get(url: String, body: RequestBody, tClass: Class<T>?, i: Int): T? {
        var url = url
        if (token == null) token = ""
        url = base + url
        try {
            if (i == 1) return g.fromJson(
                o.newCall(
                    Request.Builder().addHeader("Authorization", token!!).url(url).get().build()
                ).execute().body!!.string(), tClass
            )
            if (i == 2) return g.fromJson(
                o.newCall(
                    Request.Builder().addHeader("Authorization", token!!).url(url).post(body).build()
                ).execute().body!!.string(), tClass
            )
            if (i == 3) return g.fromJson(
                o.newCall(
                    Request.Builder().addHeader("Authorization", token!!).url(url).put(body).build()
                ).execute().body!!.string(), tClass
            )
            if (i == 4) return g.fromJson(
                o.newCall(
                    Request.Builder().addHeader("Authorization", token!!).url(url).delete().build()
                ).execute().body!!.string(), tClass
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}