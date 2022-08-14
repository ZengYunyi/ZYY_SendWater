package com.example.zyy_sendwater.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.data.model.icon

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.adapter
 * @description: zyy21
 * @date :2022/8/9 21:08
 */
class IconAdapter: BaseQuickAdapter<icon, BaseViewHolder>(R.layout.item_icon) {
    override fun convert(holder: BaseViewHolder, item: icon) {
        holder.setText(R.id.text_icon,item.title)
        var iconImage : ImageView = holder.getView(R.id.icon_image)
        Glide.with(iconImage.context).load(item.image).into(iconImage)
    }
}