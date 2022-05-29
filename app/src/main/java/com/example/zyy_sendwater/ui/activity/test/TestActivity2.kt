package com.example.zyy_sendwater.ui.activity.test

import android.app.ActivityOptions
import android.content.Intent
import android.transition.TransitionInflater
import android.util.Pair
import android.view.LayoutInflater
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.LayoutTest2Binding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/12 11:10
 */







class TestActivity2: BaseActivity<LayoutTest2Binding>(){
    override fun init() {
        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade)
        window.exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade)
        binding.test2Image.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(binding.test2Image,getString(R.string.test_name)),Pair.create(binding.test2Text,"text")
            ).toBundle())
        }
    }
}