package com.example.zyy_sendwater.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.repository.remote.StateEnum

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 15:22
 */
class HomeViewModel : ViewModel() {
    val homeLiveData = MutableLiveData<StateEnum>()
}