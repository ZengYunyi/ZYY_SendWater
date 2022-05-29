package com.example.zyy_sendwater.repository.model

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/30 14:19
 */
data class news(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int
)

data class Row(
    val appType: String,
    val commentNum: Int,
    val content: String,
    val cover: String,
    val createBy: String,
    val createTime: String,
    val hot: String,
    val id: Int,
    val likeNum: Int,
    val params: Params,
    val publishDate: String,
    val readNum: Int,
    val remark: Any,
    val searchValue: Any,
    val status: String,
    val subTitle: Any,
    val tags: Any,
    val title: String,
    val top: String,
    val type: String,
    val updateBy: String,
    val updateTime: String
)

class Params