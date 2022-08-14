package com.example.zyy_sendwater.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.zyy_sendwater.R
import com.example.zyy_sendwater.data.model.banners
import com.example.zyy_sendwater.databinding.ImageBannerBinding
import com.example.zyy_sendwater.util.Constants
import com.youth.banner.adapter.BannerAdapter

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.adapter
 * @description: zyy21
 * @date :2022/8/9 16:10
 */
class BannerAdapters(datas: List<banners.Data>):
     BannerAdapter<banners.Data, BannerAdapters.BannerViewHolder>(datas) {


     class BannerViewHolder(binding: ImageBannerBinding) : RecyclerView.ViewHolder(binding.root) {
          val binding = binding!!
     }

     override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
          return BannerViewHolder(ImageBannerBinding.inflate(LayoutInflater.from(parent!!.context),parent,false))
     }

     override fun onBindView(vb: BannerViewHolder?, data: banners.Data, position: Int, size: Int) {
          vb?.binding?.textBanner?.text = data.advTitle
          vb!!.binding.textBanner.isSelected = true
          vb?.binding?.imageBanner?.load(Constants.BASE_URL+data.advImg) {
               placeholder(R.drawable.banner_no)
          }
     }
}

