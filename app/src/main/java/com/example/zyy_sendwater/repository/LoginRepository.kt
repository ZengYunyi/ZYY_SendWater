package com.example.zyy_sendwater.repository

import com.example.zyy_sendwater.data.model.login
import com.example.zyy_sendwater.util.NetWorkUtil
import com.google.gson.JsonObject

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 14:07
 */
class LoginRepository {
    private val loginRepository by lazy {
        NetWorkUtil.service
    }

    suspend fun getLogin(username: String,password: String) : login{
        var jsonObject = JsonObject()
        jsonObject.addProperty("username",username)
        jsonObject.addProperty("password",password)
        return loginRepository.getLogin(jsonObject)
    }
}