package com.example.zyy_sendwater.ui.fragment.handbookF

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.adapter.HBABCAdapter
import com.example.zyy_sendwater.animation.CustomAnimation1
import com.example.zyy_sendwater.animation.CustomAnimation2
import com.example.zyy_sendwater.animation.CustomAnimation3
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHandbookBinding
import com.example.zyy_sendwater.util.ABC
import com.example.zyy_sendwater.viewModel.HandBookViewModel

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.ui.fragment.handbookF
 * @description: zyy21
 * @date :2022/8/14 10:38
 */
class HandBookFragment : BaseFragment<FragmentHandbookBinding>() {
    val handBookViewModel:HandBookViewModel by viewModels()
    private var clickNum = 0;
    override fun init() {
        binding.hbBack.setOnClickListener {
            remove()
            vm!!.bottomNavLiveData.value = true
        }
        binding.rvAbc.layoutManager = LinearLayoutManager(context)
        val abcAdapter = HBABCAdapter()
        binding.rvAbc.adapter = abcAdapter
        var abcList = handBookViewModel.getABCList() as MutableList<String>
        abcAdapter.data = abcList
        abcAdapter.adapterAnimation = CustomAnimation1()
        abcAdapter.setOnItemClickListener { adapter, view, position ->
            HBABCAdapter.abcNum = position
            adapter.notifyDataSetChanged()
            shortToast(abcList[position])
        }


    }
}