package com.example.zyy_sendwater.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/29 13:04
 */

//inline内联函数
inline fun <VB: ViewBinding> Any.getViewBinding(inflater: LayoutInflater,postion:Int = 0):VB{
//    javaClass.genericSuperclass获取父类的泛型，ParameterizedType参数化类型
    var vbClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    val inflate = vbClass[postion].getDeclaredMethod("inflate",LayoutInflater::class.java)
    return inflate.invoke(null,inflater) as VB//invoke()能让对象像函数一样调用方法
}

inline fun <VB: ViewBinding> Any.getViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?,
    postion:Int = 0):VB{
//    javaClass.genericSuperclass获取父类的泛型，ParameterizedType参数化类型
    var vbClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<VB>>()
    val inflate = vbClass[postion].getDeclaredMethod("inflate",LayoutInflater::class.java,ViewGroup::class.java,Boolean::class.java)
    return inflate.invoke(null,inflater,container,false) as VB//invoke()能让对象像函数一样调用方法
}

inline fun <VM: ViewModel> ComponentActivity.createViewModel(postion:Int = 0):VM{
//    javaClass.genericSuperclass获取父类的泛型，ParameterizedType参数化类型
    var vbClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    val viewModel = vbClass[postion] as Class<VM>
    return ViewModelProvider(this).get(viewModel)
}