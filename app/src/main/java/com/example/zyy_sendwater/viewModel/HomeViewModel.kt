package com.example.zyy_sendwater.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.data.model.home_data
import com.example.zyy_sendwater.data.model.rv_data_test
import com.example.zyy_sendwater.util.NetWorkUtil
import com.example.zyy_sendwater.util.StateEnum
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.ArrayList

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 15:22
 */
class HomeViewModel : ViewModel() {
    val homeLiveData = MutableLiveData<StateEnum>()
    private val bannerFlow = MutableStateFlow<String?>(null)
    val homeList = ArrayList<rv_data_test>();

    fun test(){

    }

    fun getHomeList() {
        homeList.add(rv_data_test(R.drawable.ornament,"饰品","饰品是用来装饰的物品，一般用途为美化个人外表，装点居室，美化公共环境，装点汽车。故饰品可分为以下几类：居家饰品、服饰饰品、汽车饰品等。随着佩戴饰品的人群逐渐增加，批发饰品这个行业在逐渐的兴起。"))
        homeList.add(rv_data_test(R.drawable.dress,"女装","女装行业虽然起步晚，但发展非常迅速，经历了休闲服-高端女装-少女少淑-快时尚-电商女装品牌的相继出现和发展，经过多年的发展，大大小小的女装品牌不计其数，但是有名气的女装品牌却是屈指可数，女装的品牌效应不及男装。"))
        homeList.add(rv_data_test(R.drawable.sofa,"沙发","三人沙发尺寸的长度在：1740-1950mm，深度在：810-910mm。要是家的客厅比较大，选择欧式沙发，欧式沙发看起来比较大气，比较时候大户型客厅；要是客厅比较小，那么在选择沙发时，就要注意沙发尺寸，这样才可以将客厅布置空间大小掌握适中。"))
        homeList.add(rv_data_test(R.drawable.shoe,"女鞋","女人跟鞋子的关系，很微妙。每个女人都希望拥有一双属于自己的鞋子。而且，选择一双质量好的鞋子对身心的健康发展具有促进作用。女鞋是现今女性日常服饰搭配中不可缺少的一项。"))
        homeList.add(rv_data_test(R.drawable.device,"电器","电器（electrical appliance）泛指所有用电的器具，从专业角度上来讲，主要指用于对电路进行接通、分断，对电路参数进行变换，以实现对电路或用电设备的控制、调节、切换、检测和保护等作用的电工装置、设备和元件；从普通民众的角度来讲，主要是指家庭常用的一些为生活提供便利的用电设备，如电视机、空调、冰箱、洗衣机、各种小家电等等。"))
    }
}