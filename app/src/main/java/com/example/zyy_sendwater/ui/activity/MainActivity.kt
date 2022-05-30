package com.example.zyy_sendwater.ui.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.adapter.MainVpAdapter
import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.ActivityMainBinding
import com.example.zyy_sendwater.extensions.gone
import com.example.zyy_sendwater.extensions.visible
import com.example.zyy_sendwater.ui.fragment.communityF.CommunityFragment
import com.example.zyy_sendwater.ui.fragment.homeF.HomeFragment
import com.example.zyy_sendwater.ui.fragment.meF.MeFragment
import com.example.zyy_sendwater.ui.fragment.orderF.OrderFragment
import com.example.zyy_sendwater.util.Vp2Transformer
import com.example.zyy_sendwater.util.Vp2TransformerOverlay
import com.example.zyy_sendwater.viewModel.MainViewModel
import com.gyf.immersionbar.ImmersionBar
import java.lang.reflect.Field

class MainActivity :BaseActivity<ActivityMainBinding>() {
    private lateinit var menuItem: MenuItem
    //viewModel  初始化
    val viewModel :MainViewModel by viewModels()


    //lateinit告诉系统延迟初始化对象
//    private lateinit var binding : ActivityMainBinding

    //by 是kotlin中委托的关键字 lazy是表达式
    //下方实现的是懒加载
//    private val binding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
    private var rotation_img = 90f

    override fun init() {
//        val fade=Fade()
//        fade.duration = 2000
//        window.enterTransition = fade
//        window.exitTransition = fade
        //底部导航栏监听
        val menu = binding.bottomNavigationView.menu
        menuItem = menu.getItem(0)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item:MenuItem->
            when(item.itemId){
                R.id.homeFragment ->binding.vpMain.setCurrentItem(0,false)
                R.id.orderFragment ->binding.vpMain.setCurrentItem(2,false)
                R.id.nullF -> return@setOnNavigationItemSelectedListener false
                R.id.meFragment ->binding.vpMain.setCurrentItem(3,false)
                R.id.communityFragment ->binding.vpMain.setCurrentItem(1,false)
            }
            return@setOnNavigationItemSelectedListener true
        }

        binding.btnAdd.setOnClickListener {
//            var animator = ObjectAnimator.ofFloat(binding.btnAdd,"rotation",90f,0f)
//            animator.repeatCount = ValueAnimator.INFINITE
//            animator.duration = 8000
//            animator.interpolator = LinearInterpolator()
//            animator.start()
            binding.btnAdd.animate().rotation(rotation_img).setDuration(1000)
            rotation_img = (rotation_img+90f)%180f
        }

        //navigation导航使用
//        val navController = findNavController(R.id.nav_fragment)
//
//        binding.bottomNavigationView.setupWithNavController(navController)
        //viewpager2
        val mainVpAdapter = MainVpAdapter(supportFragmentManager,lifecycle,
            listOf(HomeFragment(),CommunityFragment(),OrderFragment(),MeFragment()))
        //懒加载3个页面
        binding.vpMain.offscreenPageLimit=4
        binding.vpMain.adapter = mainVpAdapter
        //禁止viewpager2滑动
//        binding.vpMain.isUserInputEnabled = false
        //去掉Viewpager2的边界动画阴影
        try {
            //通过反射去掉阴影
            val recyclerViewField : Field = ViewPager2::class.java.getDeclaredField("mRecyclerView")
            recyclerViewField.isAccessible = true
            val  recyclerView : RecyclerView = recyclerViewField.get(binding.vpMain) as RecyclerView
            recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        } catch (e: Exception) {
        }
//        binding.vpMain.setPageTransformer(Vp2TransformerOverlay())
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //viewpager2监听事件
                when(position){
                    0,1->{
                        menuItem.isChecked=false
                        menuItem=menu.getItem(position)
                        menuItem.isChecked=true
                    }
                    2,3->{
                        menuItem.isChecked=false
                        menuItem=menu.getItem(position+1)
                        menuItem.isChecked=true
                    }
                }

            }
        })


        //ViewPager2监听
        viewModel.vpMainLiveData.observe(this){
            if(it) binding.vpMain.visible() else binding.vpMain.gone()
        }

        /**使用false隐藏，true显示
         *  viewModel.vpMainLiveData.postValue(false)
        viewModel.bottomNavLiveData.postValue(false)
         * **/

        //底部导航栏是否隐藏
        viewModel.bottomNavLiveData.observe(this){
            if(it) {
                binding.btnAdd.visible()
                binding.bottomNavigationView.visible()
            } else {
                binding.btnAdd.gone()
                binding.bottomNavigationView.gone()
            }
        }

    }


}