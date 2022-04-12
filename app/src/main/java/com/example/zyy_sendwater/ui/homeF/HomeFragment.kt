package com.example.zyy_sendwater.ui.homeF

import android.animation.Animator
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.adapter.ViewBindRVAdapter
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding
import com.example.zyy_sendwater.databinding.RvHomeTestBinding
import com.example.zyy_sendwater.repository.model.home_data

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(){
    var flag=false;
    override fun init() {
        b.btnAnim.setOnClickListener {
            with(b.image.animate()){
                if(flag){
                    flag = false
                    scaleX(1F)
                    scaleY(1F)
                    alpha(0.2F)
                    rotation(90F)
                    translationX(0F)
                    translationY(0F).setInterpolator(LinearInterpolator())
                    setListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(p0: Animator?) {

                        }

                        override fun onAnimationEnd(p0: Animator?) {

                        }

                        override fun onAnimationCancel(p0: Animator?) {

                        }

                        override fun onAnimationRepeat(p0: Animator?) {

                        }

                    }).setUpdateListener {
                        //动画更新
                    }
                    //监听器

                } else{
                    flag = true
                    scaleX(5F)
                    scaleY(5F)
                    alpha(1F)
                    rotation(45F)
                    translationX(550F)
                    translationYBy(550F).setDuration(2000L)
                }
            }
        }
    }

    override fun viewBinding(container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater,container,false)
    }
}


