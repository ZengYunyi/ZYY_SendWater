package com.example.zyy_sendwater.ui.activity.test

import android.app.ActivityOptions
import android.content.Intent
import android.transition.TransitionInflater
import android.util.Pair
import android.view.LayoutInflater
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.LayoutTest1Binding


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/12 11:10
 */
class TestActivity1 :BaseActivity<LayoutTest1Binding>(){

    override fun init() {
        //转场动画使用场景
        /*
        * 1,在两个Activity之间切换时界面的过渡效果
        * 2，两个activivty或者fragment之间的shared elements切换效果
        * 3，同一个activity中view的动画效果
        *window.enterTransition设置进场动画
        *window.exitTransition设置出场动画
        *window.returnTransition设置返回activity时动画
        *window.reenterTransition设置重新进入时动画
        * Exploade：从屏幕中间进入或退出
        * Slide：从屏幕的一边向另一边进入或退出
        * Fade:改变透明度来出现或消失
        * */
        //转场动画只能在Android5.0使用，判断API大于21
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            //true
//        }else{
//            //false
//        }
        //动态配置window content transitions
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        window.exitTransition == Exception()
        val slice = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide)
//        window.exitTransition = slice
//        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide)
        //是否运行布局时重叠
//        window.allowEnterTransitionOverlap = false
        binding.test1Image.setOnClickListener {
            val intent = Intent(this, TestActivity2::class.java)
            val sharedView = binding.test1Image
            val transitionName = getString(R.string.test_name)

//            val transient = ActivityOptions.makeSceneTransitionAnimation(this,sharedView,transitionName)
            //多个控件的办法
            val transient = ActivityOptions.makeSceneTransitionAnimation(
                this, Pair.create(binding.test1Image, getString(R.string.test_name)),
                Pair.create(binding.test1Text, "text")
            )
            startActivity(intent, transient.toBundle())
        }
    }
}

