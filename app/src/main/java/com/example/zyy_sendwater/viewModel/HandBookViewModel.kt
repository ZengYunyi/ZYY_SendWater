package com.example.zyy_sendwater.viewModel

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.study.toList
import com.example.zyy_sendwater.util.ABC

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.viewModel
 * @description: zyy21
 * @date :2022/8/14 15:10
 */
class HandBookViewModel: BaseViewModel() {
    fun getABCList(): List<String> = ABC("全部")

}