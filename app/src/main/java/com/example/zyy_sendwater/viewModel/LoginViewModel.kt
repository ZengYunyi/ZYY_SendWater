package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.data.model.login
import com.example.zyy_sendwater.repository.LoginRepository
import com.example.zyy_sendwater.util.NetWorkUtil
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/24 18:49
 */
class LoginViewModel: BaseViewModel() {
    private val loginRepository by lazy { LoginRepository() }
    val loginStateFlow = MutableStateFlow<login?>(null)
    val loginLiveData = MutableLiveData<login>()

    fun getToken(username: String,password: String){
        launchNetWork(requestBlock = {
            loginRepository.getLogin(username,password)
        }) {
            loginLiveData.value = it
        }
    }

}