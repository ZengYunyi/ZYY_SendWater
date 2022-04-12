package com.example.zyy_sendwater.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 21:06
 */
class MainVpAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle, val list: List<Fragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}