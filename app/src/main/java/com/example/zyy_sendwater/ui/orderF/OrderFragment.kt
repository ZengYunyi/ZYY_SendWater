package com.example.zyy_sendwater.ui.orderF

import android.view.ViewGroup
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding
import com.example.zyy_sendwater.databinding.FragmentOrderBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class OrderFragment : BaseFragment<FragmentOrderBinding>(){
    override fun init() {

    }

    override fun viewBinding(container: ViewGroup?): FragmentOrderBinding {
        return FragmentOrderBinding.inflate(layoutInflater,container,false)
    }
}