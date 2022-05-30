package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.util.StateEnum


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 17:13
 */
class MainViewModel :ViewModel() {
    val mainLiveData = MutableLiveData<StateEnum>()

    val bottomNavLiveData = MutableLiveData<Boolean>()
    val vpMainLiveData = MutableLiveData<Boolean>()

}