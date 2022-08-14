package com.example.zyy_sendwater.ui.activity


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import com.example.zyy_sendwater.base.BaseActivity
import com.example.zyy_sendwater.databinding.ActivityLoginBinding
import com.example.zyy_sendwater.util.NetWorkUtil
import com.example.zyy_sendwater.viewModel.LoginViewModel

import com.google.gson.JsonObject
import com.gyf.immersionbar.ImmersionBar
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/15 15:05
 */
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    val loginViewModel: LoginViewModel by viewModels()

    override fun init() {
        //沉浸式状态栏
        ImmersionBar.with(this@LoginActivity).init()


        binding.testBtn.setOnClickListener {
            if(binding.editLoginPassword.text.isNotEmpty() && binding.editLoginUsername.text.isNotEmpty()){
                loginViewModel.getToken(binding.editLoginUsername.text.toString(),binding.editLoginPassword.text.toString())
                loginViewModel.loginLiveData.observe(this) {
                    if (!it.token.equals("")) {
                        binding.text.text = "登录中"
                        binding.numderView.visibility = View.VISIBLE
                        lifecycleScope.launch{
                            delay(1000)
                            shortToast("登录成功")
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        }
                    }
                }
            }
        }
    }

}


