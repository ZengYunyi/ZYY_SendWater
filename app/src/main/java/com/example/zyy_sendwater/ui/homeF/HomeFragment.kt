package com.example.zyy_sendwater.ui.homeF

import android.view.ViewGroup
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(){
    override fun init() {

    }

    override fun viewBinding(container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater,container,false)
    }
}