package com.example.zyy_sendwater.data.model

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.data.model
 * @description: zyy21
 * @date :2022/8/8 15:36
 */
class banners{
    data class ad(
        val code: Int,
        val `data`: List<Data>,
        val msg: String,
        val total: Int
    )

    data class Data(
        val advImg: String,
        val advTitle: String,
        val id: Int,
        val servModule: String,
        val tragetId: Int,
        val type: Int
    )
}

