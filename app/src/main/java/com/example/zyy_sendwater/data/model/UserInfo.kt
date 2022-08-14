package com.example.zyy_sendwater.data.model

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 15:54
 */
class UserInfo{
    data class User(
        val code: Int,
        val `data`: Data,
        val msg: String
    )

    data class Data(
        val avatar: String,
        val content: String,
        val email: String,
        val nickName: String,
        val phone: String,
        val sex: Int,
        val userId: Int,
        val userName: String,
        val userPw: String
    )
}