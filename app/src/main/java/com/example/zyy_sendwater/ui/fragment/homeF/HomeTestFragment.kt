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
        b.homeTestTopBack.setOnClickListener {
            remove()
        }
        val bundle = arguments
        b.homeTestImage.transitionName="a2${bundle?.getString("position")!!}"
        Log.i("ddddd", "a2${bundle?.getString("position")!!}")
        b.titleHomeTest.transitionName="a1${bundle?.getString("position")!!}"
        b.homeTestImage?.load(bundle?.getInt("pic",1)!!)
        b.titleHomeTest.setText(bundle?.getString("title",""))
        b.homeTestContent.setText(bundle?.getString("content",""))
        ViewCompat.setTransitionName(b.homeTestImage,bundle?.getString("tran"))
    }

    override fun viewBinding(container: ViewGroup?): FragmentHomeTestBinding {
//TODO("Not yet implemented")
        return FragmentHomeTestBinding.inflate(layoutInflater)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vm?.bottomNavLiveData?.postValue(true)

    }
}