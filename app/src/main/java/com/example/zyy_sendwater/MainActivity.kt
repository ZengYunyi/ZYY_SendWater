package com.example.zyy_sendwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.zyy_sendwater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit告诉系统延迟初始化对象
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewpager2
        val navController = findNavController(R.id.nav_fragment)

        binding.bottomNavigationView.setupWithNavController(navController)
    }
}