package com.example.zyy_sendwater.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBinding
import com.example.zyy_sendwater.App
import com.example.zyy_sendwater.extensions.getViewBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:29
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity(){
    //activity通用适配器，简化代码
    //LazyThreadSafetyMode有三种：
    //SYNCHRONIZED同步：只会调用一次初始化方法。单例模式：懒汉式，线程安全
    //
    //PUBLICATION：会调用多次初始化方法，但只有第一次的有效。
    //
    //NONE：会调用多次，且会改变常量的值为最后一次的值。单例模式：懒汉式，线程不安
    // lazy的线程安全模式
    internal val binding: VB by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewBinding(layoutInflater)
    }

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }
    fun <T> getFlow(block:suspend()->T) : Flow<T> = flow { emit(block.invoke()) }


    //单请求
    fun <T> launchNetWork(requestBlock:suspend()->T,
                          resultCallback:(T)->Unit){
        GlobalScope.launch {
           getFlow { requestBlock.invoke() }.catch {
                it.printStackTrace()
            }.collect {
                resultCallback(it)
            }
        }
    }

    fun shortToast(name : String)= Toast.makeText(App.appContext,name, Toast.LENGTH_SHORT).show()
    fun longToast(name : String)= Toast.makeText(App.appContext,name, Toast.LENGTH_LONG).show()
}