package com.example.zyy_sendwater.ui.fragment.homeF

import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.adapter.HomeRVAdapter
import com.example.zyy_sendwater.base.BaseFragment
import com.example.zyy_sendwater.databinding.FragmentHomeBinding
//import com.example.zyy_sendwater.repository.model.rv_data_test
import com.example.zyy_sendwater.viewModel.HomeViewModel

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:33
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun init() {
        val homeFragment = HomeFragment()
        sharedElementEnterTransition = TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move)
        val slideTransition = Slide(Gravity.RIGHT);
        slideTransition.duration = 1000
        homeFragment.enterTransition = slideTransition
        val homeViewModel: HomeViewModel =
            ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        homeViewModel.getHomeList()
        val homeRVAdapter = HomeRVAdapter();
        val listhome = homeViewModel.homeList
        homeRVAdapter.setNewInstance(listhome)
        binding.homeRvTest.layoutManager = LinearLayoutManager(context)
        binding.homeRvTest.adapter = homeRVAdapter
        homeRVAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            val bundle = Bundle();
            bundle.putInt("pic", listhome.get(position).pic)
            bundle.putString("title", listhome.get(position).name)
            bundle.putString("content", listhome.get(position).content)
            bundle.putString("position", "${position}")
            bundle.putString("tran", ViewCompat.getTransitionName(view.findViewById<ImageView>(R.id.rv_image_home)))
                fragmentManager?.beginTransaction()
                    ?.add(R.id.layMain, HomeTestFragment::class.java, bundle, "")
                    ?.addSharedElement(
                        view.findViewById<TextView>(R.id.rv_home_title),
                        "a1${position}"
                    )
                    ?.addSharedElement(
                        view.findViewById<ImageView>(R.id.rv_image_home),
                        "a2${position}"

                )
                    ?.addToBackStack("")
                    ?.commit()
                Log.i("ddddd", "a2${bundle?.getString("position")!!}")

            vm?.bottomNavLiveData?.postValue(false)
        })
    }

}



