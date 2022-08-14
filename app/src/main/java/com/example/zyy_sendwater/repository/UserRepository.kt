package com.example.zyy_sendwater.repository

import com.example.zyy_sendwater.data.model.UserInfo
import com.example.zyy_sendwater.util.NetWorkUtil

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 15:55
 */
class UserRepository {
    private val userRepository by lazy {
        NetWorkUtil.service
    }

    suspend fun getUserInfo(token:String):UserInfo.User{
        return userRepository.getUserInfo(token)
    }
}