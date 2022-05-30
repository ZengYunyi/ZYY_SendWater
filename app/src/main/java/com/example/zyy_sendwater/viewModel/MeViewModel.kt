package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.util.StateEnum


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:05
 */
class MeViewModel : ViewModel(){
    var meLiveData = MutableLiveData<StateEnum>();
}