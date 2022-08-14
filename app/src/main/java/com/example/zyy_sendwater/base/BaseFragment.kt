package com.example.zyy_sendwater.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.extensions.getViewBinding
import com.example.zyy_sendwater.viewModel.MainViewModel


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:08
 */
abstract class BaseFragment<VB : ViewDataBinding> : Fragment(){
    var vm : MainViewModel? = null
    //fragment通用适配器简化代码
    protected lateinit var binding : VB
        //私有修饰符不允许声明在当前作用域之外可见。
        private set


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater,container)
        binding.root.setBackgroundColor(Color.WHITE)
        vm = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    //删除fragment
    fun remove() = requireActivity().supportFragmentManager.popBackStack()
    //添加fragment
    open fun add(fragment: Fragment) = requireActivity().supportFragmentManager.beginTransaction().add(
        R.id.layMain,fragment).setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_out_right).addToBackStack(null).commit()
    //提示窗显示长短
//    fun shortToast(name : String)=Snackbar.make(context,name,Snackbar.LENGTH_LONG).show()
    fun shortToast(name : String)=Toast.makeText(context,name,Toast.LENGTH_SHORT).show()
    fun longToast(name : String)=Toast.makeText(context,name,Toast.LENGTH_LONG).show()

    open fun jump(fragmentClass: Class<out Fragment?>?, bundle: Bundle?, tag: String?) {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.fade_in,
                android.R.anim.slide_out_right
            )
            .addToBackStack(tag)
            .add(R.id.layMain, fragmentClass!!, bundle)
            .commit()
    }

    open fun jumpHide(fragmentClass: Class<out Fragment?>?, bundle: Bundle?, tag: String?) {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.fade_in,
                android.R.anim.slide_out_right
            )
            .addToBackStack(tag)
            .add(R.id.layMain, fragmentClass!!, bundle, tag)
            .hide(this)
            .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        //取消绑定，避免内存泄露
//        ::binding.isInitialized用于判断binding是否已经初始化，如果没有，则取！进入if，进行初始化
        if(::binding.isInitialized){
            binding.unbind()
        }
    }

    protected abstract fun init()
}