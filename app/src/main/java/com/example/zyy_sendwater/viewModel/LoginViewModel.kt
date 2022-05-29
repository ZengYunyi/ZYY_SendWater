package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.repository.model.login
import com.example.zyy_sendwater.util.NetWorkUtil
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/24 18:49
 */
class LoginViewModel: BaseViewModel() {
    val loginStateFlow = MutableStateFlow<login?>(null)
    val loginLiveData = MutableLiveData<login>()
    fun getToken(username: String,password: String){
        var jsonObject = JsonObject()
        jsonObject.addProperty("username",username)
        jsonObject.addProperty("password",password)
        launchNetWork(requestBlock = {
            NetWorkUtil.service.getLogin(jsonObject)
        }) {
            loginLiveData.value = it
        }
    }
}