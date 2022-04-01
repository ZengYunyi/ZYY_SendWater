package com.example.zyy_sendwater.ui.meF

import android.view.ViewGroup
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding
import com.example.zyy_sendwater.databinding.FragmentMeBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class MeFragment : BaseFragment<FragmentMeBinding>(){
    override fun init() {

    }

    override fun viewBinding(container: ViewGroup?): FragmentMeBinding {
        return FragmentMeBinding.inflate(layoutInflater,container,false)
    }
}