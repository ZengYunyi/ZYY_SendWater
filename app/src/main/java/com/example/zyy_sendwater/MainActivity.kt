package com.example.zyy_sendwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.zyy_sendwater.adapter.MainVpAdapter
import com.example.zyy_sendwater.databinding.ActivityMainBinding
import com.example.zyy_sendwater.ui.homeF.HomeFragment
import com.example.zyy_sendwater.ui.meF.MeFragment
import com.example.zyy_sendwater.ui.orderF.OrderFragment
import com.example.zyy_sendwater.viewModel.MainViewModel
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    private lateinit var menuItem: MenuItem
    //viewModel  初始化
    private val viewModel :MainViewModel by viewModels()


    //lateinit告诉系统延迟初始化对象
//    private lateinit var binding : ActivityMainBinding

    //by 是kotlin中委托的关键字 lazy是表达式
    //下方实现的是懒加载
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //底部导航栏监听
        val menu = binding.bottomNavigationView.menu
        menuItem = menu.getItem(0)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item:MenuItem->
            when(item.itemId){
                R.id.homeFragment->binding.vpMain.setCurrentItem(0,false)
                R.id.orderFragment->binding.vpMain.setCurrentItem(1,false)
                R.id.meFragment->binding.vpMain.setCurrentItem(2,false)
            }
            return@setOnNavigationItemSelectedListener true
        }


      //navigation导航使用
//        val navController = findNavController(R.id.nav_fragment)
//
//        binding.bottomNavigationView.setupWithNavController(navController)
        //viewpager2
        val mainVpAdapter = MainVpAdapter(supportFragmentManager,lifecycle,
        listOf(HomeFragment(),OrderFragment(),MeFragment()))
        //懒加载3个页面
        binding.vpMain.offscreenPageLimit=3
        binding.vpMain.adapter = mainVpAdapter
        //去掉Viewpager2的边界动画阴影
        try {
            //通过反射去掉阴影
            val recyclerViewField : Field = ViewPager2::class.java.getDeclaredField("mRecyclerView")
            recyclerViewField.isAccessible = true
            val  recyclerView : RecyclerView = recyclerViewField.get(binding.vpMain) as RecyclerView
            recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        } catch (e: Exception) {
        }
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                menuItem.isChecked=false
                menuItem=menu.getItem(position)
                menuItem.isChecked=true
                //viewpager2监听事件
                when(position){
                    1->{

                    }
                }
            }
        })


        //ViewPager2监听
        viewModel.vpMainLiveData.observe(this){
            binding.vpMain.visibility = if(it) View.VISIBLE else View.GONE
        }

        /**使用false隐藏，true显示
         *  viewModel.vpMainLiveData.postValue(false)
        viewModel.bottomNavLiveData.postValue(false)
         * **/

        //底部导航栏是否隐藏
        viewModel.bottomNavLiveData.observe(this){
            binding.bottomNavigationView.visibility = if(it) View.VISIBLE else View.GONE
        }


    }



}