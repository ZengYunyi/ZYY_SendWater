package com.example.zyy_sendwater.adapter

import androidx.core.view.ViewCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.data.model.rv_data_test

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/2 17:53
 */
class HomeRVAdapter : BaseQuickAdapter<rv_data_test,BaseViewHolder>(R.layout.rv_home_test){

    override fun convert(holder: BaseViewHolder, item: rv_data_test) {
        holder.setText(R.id.rv_home_title,item.name)
        holder.setText(R.id.rv_home_content,item.content)
        holder.setBackgroundResource(R.id.rv_image_home,item.pic)
        ViewCompat.setTransitionName(holder.itemView.findViewById(R.id.rv_image_home), item.pic.toString())
    }



}