package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.data.model.UserInfo
import com.example.zyy_sendwater.repository.UserRepository
import com.example.zyy_sendwater.util.SPUtil
import com.example.zyy_sendwater.util.StateEnum


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 17:13
 */
class MainViewModel :BaseViewModel() {
    val mainLiveData = MutableLiveData<StateEnum>()
    val userLiveData = MutableLiveData<StateEnum>()
    val userRepository by lazy { UserRepository() }
    val bottomNavLiveData = MutableLiveData<Boolean>()
    val vpMainLiveData = MutableLiveData<Boolean>()

    lateinit var user: UserInfo.User

    fun getUserList(){
        launchNetWork(requestBlock = {
             userRepository.getUserInfo(SPUtil.getTokenSP()!!)
        }, resultCallback = {
            user = it
            userLiveData.value = StateEnum.SUCCESS
        })
    }
}