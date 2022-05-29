package com.example.zyy_sendwater.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBinding
import com.example.zyy_sendwater.App
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