package com.example.zyy_sendwater.ui.activity

import android.app.ActivityOptions
import android.content.Intent
import android.util.Pair
import android.view.LayoutInflater
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.ActivityStartBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/15 15:05
 */
class StartActivity : BaseActivity<ActivityStartBinding>() {
    override fun viewBinding(layoutInflater: LayoutInflater): ActivityStartBinding {
//TODO("Not yet implemented")
        return ActivityStartBinding.inflate(layoutInflater)
    }

    override fun init() {
//TODO("Not yet implemented")
        b.imagePage.setOnClickListener {
            val intent =Intent(this, MainActivity::class.java)
            val transient  = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(b.imagePage,getString(
                R.string.strat_bottom
            )))
            startActivity(intent,transient.toBundle())
            finish()
        }
    }
}