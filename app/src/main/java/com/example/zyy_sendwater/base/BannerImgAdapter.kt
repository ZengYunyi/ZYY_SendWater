package com.example.zyy_sendwater.base

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.zyy_sendwater.R
import com.youth.banner.adapter.BannerAdapter

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/1 16:52
 */
class BannerImgAdapter(val list: List<Int>): BannerAdapter<Int,BannerImgAdapter.VH>(list) {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView =  itemView.findViewById(R.id.image_banner)
    }

    override fun onCreateHolder(p0: ViewGroup?, p1: Int): VH {
        return VH(LayoutInflater.from(p0?.context).inflate(R.layout.image_banner,p0,false))
    }

    override fun onBindView(p0: VH?, p1: Int?, p2: Int, p3: Int) {
        p0?.imageView?.load(p1!!)
    }

}