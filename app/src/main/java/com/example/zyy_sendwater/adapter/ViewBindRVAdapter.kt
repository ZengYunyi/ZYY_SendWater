package com.example.zyy_sendwater.adapter

import android.view.View
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.data.model.login

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/2 16:59
 */
abstract class ViewBindRVAdapter<binding : ViewBinding,T>(layoutResId: Int) :
    BaseQuickAdapter<T, ViewBindRVAdapter.BaseViewBindingHolder<binding>>(layoutResId) {

    override fun convert(holder: BaseViewBindingHolder<binding>, item: T) {
        initRVAd(holder,item)
    }

    abstract fun initRVAd(binding: BaseViewBindingHolder<binding>,data: T)

    class BaseViewBindingHolder <VB : ViewBinding>(vb: VB) : BaseViewHolder(vb.root)

}