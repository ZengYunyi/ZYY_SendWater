package com.example.zyy_sendwater.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:29
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    //activity通用适配器，简化代码
    protected abstract fun viewBinding(layoutInflater: LayoutInflater):T
    protected abstract fun init()

    private var binding : T? = null
    val b:T
        get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewBinding(layoutInflater)
        setContentView(binding?.root)
        init()
    }
}