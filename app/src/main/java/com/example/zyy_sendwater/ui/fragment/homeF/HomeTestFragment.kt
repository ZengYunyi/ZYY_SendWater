package com.example.zyy_sendwater.ui.fragment.homeF

import android.transition.TransitionInflater
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import coil.load
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeTestBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/12 21:29
 */
class HomeTestFragment: BaseFragment<FragmentHomeTestBinding>() {
    override fun init() {
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.activity_slide)
        binding.homeTestTopBack.setOnClickListener {
            remove()
        }
        val bundle = arguments
        binding.homeTestImage.transitionName="a2${bundle?.getString("position")!!}"
        Log.i("ddddd", "a2${bundle?.getString("position")!!}")
        binding.titleHomeTest.transitionName="a1${bundle?.getString("position")!!}"
        binding.homeTestImage?.load(bundle?.getInt("pic",1)!!)
        binding.titleHomeTest.setText(bundle?.getString("title",""))
        binding.homeTestContent.setText(bundle?.getString("content",""))
        ViewCompat.setTransitionName(binding.homeTestImage,bundle?.getString("tran"))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        vm?.bottomNavLiveData?.postValue(true)

    }
}