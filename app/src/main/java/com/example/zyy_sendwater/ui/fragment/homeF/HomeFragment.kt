package com.example.zyy_sendwater.ui.fragment.homeF

import android.R
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zyy_sendwater.App
import com.example.zyy_sendwater.adapter.BannerAdapters
import com.example.zyy_sendwater.adapter.IconAdapter
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding
import com.example.zyy_sendwater.ui.fragment.handbookF.HandBookFragment
import com.example.zyy_sendwater.util.StateEnum
import com.example.zyy_sendwater.viewModel.HomeViewModel
import com.youth.banner.indicator.CircleIndicator
import java.util.*


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    val homeViewModel :HomeViewModel by viewModels()

    override fun init() {
        homeViewModel.getAdInfo()
        homeViewModel.getIconInfo()
        homeViewModel.homeLiveData.observe(this) {
            when (it) {
                StateEnum.SUCCESS->{
                    binding.homeBanner.apply {
                        setAdapter(BannerAdapters(homeViewModel.bannerList!!))
                        addBannerLifecycleObserver(this@HomeFragment)
                        setIndicator(CircleIndicator(binding.homeBanner.context));
                        setBannerGalleryMZ(20,0.8f)
                        setIndicatorWidth(20,20)
                        start()
                    }
                }
                StateEnum.FAIL->{

                }
            }
        }
        binding.rvHomeIcon.layoutManager = GridLayoutManager(App.appContext,3)
        var iconAdapter = IconAdapter()
        var iconList = homeViewModel.iconList
        iconAdapter.data = iconList
        binding.rvHomeIcon.adapter = iconAdapter
        iconAdapter.setOnItemClickListener { adapter, view, position ->
            when(iconList[position].title){
                "作物指南"->{}
                "植物库"->{
                    jump(HandBookFragment::class.java,null,"handbook")
                    vm!!.bottomNavLiveData.value = false
                }
                "集市"->{}
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.homeBanner.stop()
    }

}



