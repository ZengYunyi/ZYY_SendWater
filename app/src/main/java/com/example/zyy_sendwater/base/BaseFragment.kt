package com.example.zyy_sendwater.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.zyy_sendwater.R
import com.google.android.material.snackbar.Snackbar

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:08
 */
abstract class BaseFragment<T : ViewBinding> : Fragment(){
    //fragment通用适配器简化代码
    private var binding : T? = null
    val b:T
        get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = viewBinding(container)
        init()
        return binding?.root
    }
    //删除fragment
    fun remove() = requireActivity().supportFragmentManager.popBackStack()
    //添加fragment
    open fun add(fragment: Fragment) = requireActivity().supportFragmentManager.beginTransaction().add(
        R.id.nav_fragment,fragment).setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_out_right).addToBackStack(null).commit()
    //提示窗显示长短
//    fun shortToast(name : String)=Snackbar.make(context,name,Snackbar.LENGTH_LONG).show()
    fun shortToast(name : String)=Toast.makeText(context,name,Toast.LENGTH_SHORT).show()
    fun longToast(name : String)=Toast.makeText(context,name,Toast.LENGTH_LONG).show()



    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }

    protected abstract fun init()

    protected abstract fun viewBinding(container: ViewGroup?):T
}