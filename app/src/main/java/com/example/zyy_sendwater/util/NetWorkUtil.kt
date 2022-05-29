package com.example.zyy_sendwater.util

import com.example.zyy_sendwater.interfaces.Apiservice
import com.google.gson.internal.GsonBuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/2 16:48
 */
object NetWorkUtil  {

    val service by lazy { getService(Apiservice::class.java,Constants.BASE_URL)}

    private val client: OkHttpClient by lazy {
        val builder =  OkHttpClient.Builder()
            .connectTimeout(60,TimeUnit.SECONDS)//设置超时时间
            .readTimeout(60,TimeUnit.SECONDS)//设置读超时
            .writeTimeout(60,TimeUnit.SECONDS)//设置写超时
            .retryOnConnectionFailure(true)//设置是否重连
        builder.build()
    }

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Apiservice::class.java)

    fun <S> getService(serviceClass: Class<S>,beseUrl:String):S =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(beseUrl)
            .build()
            .create(serviceClass)
}



