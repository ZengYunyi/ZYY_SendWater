package com.example.zyy_sendwater.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.zyy_sendwater.App
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.data.model.easyerror
import com.example.zyy_sendwater.data.model.login
import com.example.zyy_sendwater.repository.LoginRepository
import com.example.zyy_sendwater.util.NetWorkUtil
import com.example.zyy_sendwater.util.SPUtil
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import kotlin.coroutines.coroutineContext

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/24 18:49
 */
class LoginViewModel: BaseViewModel() {
    private val loginRepository by lazy { LoginRepository() }
    val loginStateFlow = MutableStateFlow<login?>(null)
    val loginLiveData = MutableLiveData<login>()
    val sharedPreferences by lazy { SPUtil.sp("user",App.appContext) }
    fun getToken(username: String,password: String){
        launchNetWork(requestBlock = {
            loginRepository.getLogin(username,password)
        }) {
            sharedPreferences.edit().putString("token",it.token).commit()
            loginLiveData.value = it
        }
    }

}