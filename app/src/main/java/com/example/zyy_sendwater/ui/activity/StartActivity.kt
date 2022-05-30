package com.example.zyy_sendwater.ui.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.util.Pair
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.ActivityStartBinding
import com.gyf.immersionbar.ImmersionBar
import kotlinx.coroutines.*

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/15 15:05
 */
class StartActivity : BaseActivity<ActivityStartBinding>() {

    override fun init() {
        ImmersionBar.with(this@StartActivity).statusBarDarkFont(true).init()

        binding.rectView.setDotColor(Color.parseColor("#1296db"))
        binding.numderView.setTextColor(Color.parseColor("#1296db"))
        binding.numderView.setFirstColor(Color.parseColor("#1296db"))
        binding.numderView.setSecondColor(Color.parseColor("#1296db"))
        binding.numderView.setCircleWidth(4)
        binding.numderView.setProgress(0,true)

        var animator = ObjectAnimator.ofFloat(binding.rectView,"rotation",360f,0f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 8000
        animator.interpolator = LinearInterpolator()
        animator.start()

        GlobalScope.launch(Dispatchers.Main) {
            for(i in 1..100){
                withContext(Dispatchers.IO){
                    delay(50)
                    binding.numderView.setProgress(i)
                }
            }
            jumpLogin()
        }

        binding.frameStart.setOnClickListener {
           jumpLogin()
        }
    }
    fun jumpLogin(){
        val intent =Intent(this, LoginActivity::class.java)
        val transient  = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(binding.imageStart,getString(
            R.string.strat_bottom
        )))
        startActivity(intent,transient.toBundle())
        GlobalScope.launch {
            delay(1000)
            finish()
        }
    }
}