package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.repository.remote.StateEnum

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:06
 */
class OrderViewModel : ViewModel() {
    var orderLiveData = MutableLiveData<StateEnum>();
}