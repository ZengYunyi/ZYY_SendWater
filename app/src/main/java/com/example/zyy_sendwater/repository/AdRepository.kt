package com.example.zyy_sendwater.repository

import com.example.zyy_sendwater.data.model.UserInfo
import com.example.zyy_sendwater.data.model.banners
import com.example.zyy_sendwater.util.NetWorkUtil

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.repository
 * @description: zyy21
 * @date :2022/8/8 15:32
 */
class AdRepository {
    private val adRepository by lazy {
        NetWorkUtil.service
    }
    suspend fun getAdInfo(): banners.ad {
        return adRepository.getAdInfo()
    }
}