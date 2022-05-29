package com.example.zyy_sendwater.interfaces

import com.example.zyy_sendwater.repository.model.Row
import com.example.zyy_sendwater.repository.model.login
import com.example.zyy_sendwater.repository.model.news
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
    suspend fun getLogin(@Body jsonObject: JsonObject):login
}