package com.example.zyy_sendwater.adapter

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.R

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.adapter
 * @description: zyy21
 * @date :2022/8/14 15:36
 */
class HBABCAdapter: BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_abc_hb){
    companion object{
        var abcNum = 0
    }
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.rv_abc_text,item)
        if(holder.layoutPosition==abcNum) {
            holder.setBackgroundColor(R.id.rv_abc_text, Color.TRANSPARENT)
        }else{
            holder.setBackgroundColor(R.id.rv_abc_text, Color.WHITE)
        }
    }
}