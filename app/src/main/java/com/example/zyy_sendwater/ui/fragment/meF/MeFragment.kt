package com.example.zyy_sendwater.ui.fragment.meF

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentMeBinding
import kotlinx.coroutines.*

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class MeFragment : BaseFragment<FragmentMeBinding>(){
    override fun init() {
//        b.dotView.setDotColor(Color.parseColor("#1296db"))
//        b.dotView.setDotColor(Color.parseColor("#1296db"))
        b.rectView.setDotColor(Color.parseColor("#1296db"))
        b.numderView.setTextColor(Color.parseColor("#1296db"))
        b.numderView.setFirstColor(Color.parseColor("#1296db"))
        b.numderView.setSecondColor(Color.parseColor("#1296db"))
        b.numderView.setCircleWidth(7)
        b.numderView.setProgress(0,true)
//        var animator = ObjectAnimator.ofFloat(b.dotView,"rotation",0f,360f)
//        animator.repeatCount = ValueAnimator.INFINITE
//        animator.interpolator = LinearInterpolator()
//        animator.duration = 7000
//        animator.start()

        var animator = ObjectAnimator.ofFloat(b.rectView,"rotation",360f,0f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 8000
        animator.interpolator = LinearInterpolator()
        animator.start()
        b.btn.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                for(i in 0..100){
                    withContext(Dispatchers.IO){
                        delay(100)
                    }
                    b.numderView.setProgress(i)
                }

            }
        }
    }

    override fun viewBinding(container: ViewGroup?): FragmentMeBinding {
        return FragmentMeBinding.inflate(layoutInflater,container,false)
    }
}