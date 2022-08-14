package com.example.zyy_sendwater.interfaces

import com.example.zyy_sendwater.data.model.*
import com.example.zyy_sendwater.util.Constants
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/30 12:41
 */
interface Apiservice {
    /*
    * 智慧城市登录接口
    */

    @POST("/login")
    suspend fun getLogin(@Body jsonObject: JsonObject): login

    @GET("/getUserInfo")
    suspend fun getUserInfo(@Header("token") token:String) : UserInfo.User

    @GET(Constants.HOME_BANNER)
    suspend fun getAdInfo():banners.ad

}