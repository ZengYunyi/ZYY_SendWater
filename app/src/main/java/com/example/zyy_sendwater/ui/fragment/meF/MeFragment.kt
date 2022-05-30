package com.example.zyy_sendwater.ui.fragment.meF

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.viewModels
import coil.load
import com.bumptech.glide.Glide
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentMeBinding
import com.example.zyy_sendwater.util.StateEnum
import com.example.zyy_sendwater.viewModel.MainViewModel
import kotlinx.coroutines.*

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class MeFragment : BaseFragment<FragmentMeBinding>(){
    val mainViewModel:MainViewModel by viewModels()
    override fun init() {
        mainViewModel.getUserList()
        mainViewModel.userLiveData.observe(this){
            when(it){
                StateEnum.SUCCESS->{
                    binding.user = mainViewModel.user
                    Glide.with(binding.btnTouxiang.context).load(mainViewModel.user.data.avatar).into(binding.btnTouxiang)
                }
            }

        }
    }
}