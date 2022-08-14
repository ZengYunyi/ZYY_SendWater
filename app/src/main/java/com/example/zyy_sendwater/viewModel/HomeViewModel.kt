package com.example.zyy_sendwater.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.base.BaseViewModel
import com.example.zyy_sendwater.data.model.banners
import com.example.zyy_sendwater.data.model.icon
import com.example.zyy_sendwater.repository.AdRepository

import com.example.zyy_sendwater.util.StateEnum

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 15:22
 */
class HomeViewModel : BaseViewModel() {
    private val homeRepository by lazy {
        AdRepository()
    }
    var bannerList: List<banners.Data>? = null
    var iconList:MutableList<icon> = mutableListOf<icon>()
    val homeLiveData = MutableLiveData<StateEnum>()
    fun getAdInfo(){
        launchNetWork(requestBlock = {
            homeRepository.getAdInfo()
        },{
            bannerList = it.data
            if(bannerList!=null){

                homeLiveData.value = StateEnum.SUCCESS
            }else{
                homeLiveData.value = StateEnum.FAIL
            }
        })
    }
    fun getIconInfo(){
        iconList.add(icon(R.drawable.icon_handbook,"作物指南"))
        iconList.add(icon(R.drawable.icon_discern,"植物库"))
        iconList.add(icon(R.drawable.icon_shop,"集市"))
    }
}